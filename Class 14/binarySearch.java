import org.junit.Test;
import static org.junit.Assert.*;

public class binarySearch<T extends Comparable<T>> {

    public int search(T[] items, T goal, int l, int r) {
        if(l > r) return -1;
        int m = (l + r) / 2;
        int cmp = goal.compareTo(items[m]);
        if (cmp < 0) {
            return search(items, goal, l, m - 1);
        }
        else if (cmp > 0) {
            return search(items, goal, m + 1, r);
        }
        else {
            return m;
        }
    }

    @Test
    public void testString() {
        String[] sorts = {"acer", "compare", "demon", "fag", "lucy"};
        binarySearch<String> bs = new binarySearch<>();
        assertEquals(3, bs.search(sorts, "fag", 0, sorts.length - 1));
    }

    @Test
    public void testInt() {
        Integer[] sorts2 = {1, 4, 6, 9, 18, 37, 65};
        binarySearch<Integer> bs2 = new binarySearch<>();
        assertEquals(1, bs2.search(sorts2, 4, 0, sorts2.length - 1));
    }

}
