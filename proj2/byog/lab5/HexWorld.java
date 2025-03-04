package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;
import java.awt.Color;

import java.util.Random;

import javax.swing.text.Position;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final Random RANDOM = new Random();
    
    public static class Position {
        int x;
        int y;

        public Position(int x0, int y0){
            x = x0;
            y = y0;
        }
    }

    /**
     * Computes the width of row i for a size s hexagon.
     * @param s The size of the hex.
     * @param i The row number where i = 0 is the bottom row.
     * @return
     */
    public static int hexRowWidth(int s, int i) {
        int effectiveI = i;
        if (i >= s) {
            effectiveI = 2 * s - 1 - effectiveI;
        }

        return s + 2 * effectiveI;
    }

    /**
     * Computesrelative x coordinate of the leftmost tile in the ith
     * row of a hexagon, assuming that the bottom row has an x-coordinate
     * of zero. For example, if s = 3, and i = 2, this function
     * returns -2, because the row 2 up from the bottom starts 2 to the left
     * of the start position, e.g.
     *   xxxx
     *  xxxxxx
     * xxxxxxxx
     * xxxxxxxx <-- i = 2, starts 2 spots to the left of the bottom of the hex
     *  xxxxxx
     *   xxxx
     *
     * @param s size of the hexagon
     * @param i row num of the hexagon, where i = 0 is the bottom
     * @return
     */
    public static int hexRowOffset(int s, int i) {
        int effectiveI = i;
        if (i >= s) {
            effectiveI = 2 * s - 1 - effectiveI;
        }
        return -effectiveI;
    }

    /** Adds a row of the same tile.
     * @param world the world to draw on
     * @param p the leftmost position of the row
     * @param width the number of tiles wide to draw
     * @param t the tile to draw
     */
    public static void addRow(TETile[][] world, Position p, int width, TETile t) {
        for (int xi = 0; xi < width; xi += 1) {
            int xCoord = p.x + xi;
            int yCoord = p.y;
            world[xCoord][yCoord] = TETile.colorVariant(t, 32, 32, 32, RANDOM);
        }
    }

    /**
     * Adds a hexagon to the world.
     * @param world the world to draw on
     * @param p the bottom left coordinate of the hexagon
     * @param s the size of the hexagon
     * @param t the tile to draw
     */
    public static void addHexagon(TETile[][] world, Position p, int s, TETile t) {

        if (s < 2) {
            throw new IllegalArgumentException("Hexagon must be at least size 2.");
        }

        // hexagons have 2*s rows. this code iterates up from the bottom row,
        // which we call row 0.
        for (int yi = 0; yi < 2 * s; yi += 1) {
            int thisRowY = p.y + yi;

            int xRowStart = p.x + hexRowOffset(s, yi);
            Position rowStartP = new Position(xRowStart, thisRowY);

            int rowWidth = hexRowWidth(s, yi);

            addRow(world, rowStartP, rowWidth, t);

        }
    }

        /**
     * Computes the position of the top right neighbor of a hexagon.
     * @param p The position of the bottom left of the hexagon.
     * @param s The size of the hexagon.
     * @return The position of the bottom left of the top right neighbor.
     */
    public static Position topRightNeighbor(Position p, int s) {
        int x = p.x + 2 * s - 1;
        int y = p.y + s;
        return new Position(x, y);
    }

    /**
     * Computes the position of the bottom right neighbor of a hexagon.
     * @param p The position of the bottom left of the hexagon.
     * @param s The size of the hexagon.
     * @return The position of the bottom left of the bottom right neighbor.
     */
    public static Position bottomRightNeighbor(Position p, int s) {
        int x = p.x + 2 * s - 1;
        int y = p.y - s;
        return new Position(x, y);
    }

    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(5);
        TETile t = switch (tileNum) {
            case 0 -> Tileset.GRASS;
            case 1 -> Tileset.FLOWER;
            case 2 -> Tileset.SAND;
            case 3 -> Tileset.MOUNTAIN;
            case 4 -> Tileset.TREE;
            default -> Tileset.NOTHING;
        };
        return TETile.colorVariant(t, 70, 70, 70, RANDOM);
    }

    /**
     * Draws a column of N hexes, each one with a random biome.
     * @param world the world to draw on
     * @param p the bottom left coordinate of the bottom hexagon
     * @param s the size of the hexagon
     * @param n the number of hexagons to draw
     */
    public static void drawRandomVerticalHexes(TETile[][] world, Position p, int s, int n) {
        Position current = p;
        for (int i = 0; i < n; i++) {
            TETile t = randomTile();
            addHexagon(world, current, s, t);
            current = new Position(current.x, current.y + 2 * s);
        }
    }

/**
 * Generates the hexagon world.
 * @param world the world to draw on
 * @param startP the bottom left coordinate of the bottom hexagon
 * @param s the size of the hexagon
 */
public static void generateHexagonWorld(TETile[][] world, Position startP, int s) {
    // 定义五列六边形的高度
    int[] columnHeights = {3, 4, 5, 4, 3};
    
    // 计算每列的起始位置并绘制六边形
    Position[] columnPositions = calculateColumnPositions(startP, s, columnHeights);
    
    // 绘制每列的六边形
    for (int i = 0; i < columnPositions.length; i++) {
        Position adjustedPosition = adjustPositionForColumn(columnPositions[i], i, columnHeights, s);
        drawRandomVerticalHexes(world, adjustedPosition, s, columnHeights[i]);
    }
}

/**
 * 计算每列的起始位置
 * @param startP 第一列的起始位置
 * @param s 六边形大小
 * @param columnHeights 每列的六边形数量
 * @return 每列的起始位置数组
 */
private static Position[] calculateColumnPositions(Position startP, int s, int[] columnHeights) {
    Position[] positions = new Position[columnHeights.length];
    positions[0] = startP;
    
    for (int i = 1; i < columnHeights.length; i++) {
        // 根据列索引确定移动方向
        boolean isMovingUp = i <= 2;
        positions[i] = getNextColumnPosition(positions[i-1], s, isMovingUp);
    }
    
    return positions;
}

/**
 * 计算下一列的起始位置
 * @param prevPosition 前一列的起始位置
 * @param s 六边形大小
 * @param isMovingUp 是否向上移动
 * @return 下一列的起始位置
 */
private static Position getNextColumnPosition(Position prevPosition, int s, boolean isMovingUp) {
    int x = prevPosition.x + 2 * s - 1;  // 水平移动距离，减1以消除间隙
    int y;
    
    if (isMovingUp) {
        y = prevPosition.y + s;  // 向上移动
    } else {
        y = prevPosition.y - s;  // 向下移动
    }
    
    return new Position(x, y);
}

/**
 * 调整列的起始位置，使底部对齐
 * @param basePosition 列的基础位置
 * @param columnIndex 列索引
 * @param columnHeights 每列的高度
 * @param s 六边形大小
 * @return 调整后的位置
 */
private static Position adjustPositionForColumn(Position basePosition, int columnIndex, 
                                               int[] columnHeights, int s) {
    int yOffset = 0;
    
    // 计算垂直偏移，使得底部对齐
    if (columnIndex != 2) {  // 中间列不需要调整
        int heightDifference = columnHeights[2] - columnHeights[columnIndex];
        yOffset = heightDifference * 2 * s;
    }
    
    return new Position(basePosition.x, basePosition.y + yOffset);
}

    public static void main(String[] args) {
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        int WIDTH = 100;
        int HEIGHT = 80;
        
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        int s = 3; // hexagon size
        Position startP = new Position(20, 20);

        // Generate the hexagon world
        generateHexagonWorld(world, startP, s);

        // draws the world to the screen
        ter.renderFrame(world);
    }

    @Test
    public void testHexRowWidth() {
        assertEquals(3, hexRowWidth(3, 5));
        assertEquals(5, hexRowWidth(3, 4));
        assertEquals(7, hexRowWidth(3, 3));
        assertEquals(7, hexRowWidth(3, 2));
        assertEquals(5, hexRowWidth(3, 1));
        assertEquals(3, hexRowWidth(3, 0));
        assertEquals(2, hexRowWidth(2, 0));
        assertEquals(4, hexRowWidth(2, 1));
        assertEquals(4, hexRowWidth(2, 2));
        assertEquals(2, hexRowWidth(2, 3));
    }

    @Test
    public void testHexRowOffset() {
        assertEquals(0, hexRowOffset(3, 5));
        assertEquals(-1, hexRowOffset(3, 4));
        assertEquals(-2, hexRowOffset(3, 3));
        assertEquals(-2, hexRowOffset(3, 2));
        assertEquals(-1, hexRowOffset(3, 1));
        assertEquals(0, hexRowOffset(3, 0));
        assertEquals(0, hexRowOffset(2, 0));
        assertEquals(-1, hexRowOffset(2, 1));
        assertEquals(-1, hexRowOffset(2, 2));
        assertEquals(0, hexRowOffset(2, 3));
    }
}
