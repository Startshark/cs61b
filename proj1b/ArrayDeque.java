public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int front;
    private int back;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        front = 4;
        back = 4;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        int len = items.length;
        if (size == len) {
            T[] p = (T[]) new Object[2 * len];
            int newFront = len / 2;
            int newBack = newFront + size - 1;
            for (int i = 0; i < size; i++) {
                p[newFront + i] = items[(front + i) % len];
            }
            items = p;
            front = newFront;
            back = newBack;
        } else if (len >= 16 && size < len / 4) {
            T[] p = (T[]) new Object[len / 2];
            int newFront = len / 4;
            int newBack = newFront + size - 1;
            for (int i = 0; i < size; i++) {
                p[newFront + i] = items[(front + i) % len];
            }
            items = p;
            front = newFront;
            back = newBack;
        }
    }

    private int plus(int num) {
        return (num == items.length - 1) ? 0 : num + 1;
    }

    private int minus(int num) {
        return (num == 0) ? items.length - 1 : num - 1;
    }

    @Override
    public void addFirst(T item) {
        resize();
        while (items[front] != null) {
            front = minus(front);
        }
        items[front] = item;
        size++;
    }

    @Override
    public void addLast(T item) {
        resize();
        while (items[back] != null) {
            back = plus(back);
        }
        items[back] = item;
        size++;
    }

    @Override
    public T removeFirst() {
        if (size <= 0) {
            return null;
        }

        T returnItem = items[front];
        items[front] = null;
        front = plus(front);
        size--;
        
        if (size == 0) {
            front = 0;
            back = 0;
        }

        resize();
        return returnItem;
    }

    @Override
    public T removeLast() {
        if (size <= 0) return null;
        
        T returnItem = items[back];
        items[back] = null;
        back = minus(back);
        size--;

        if (size == 0) {
            front = 0;
            back = 0;
        }
        
        resize();
        return returnItem;
    }
    
    @Override
    public void printDeque() {
        int f = front, b = back;
        if (f == b) System.out.println();
        while (f != b) {
            System.out.print(items[f] + " ");
            f = plus(f);
            if (f == b) System.out.println(items[f]);
        }
        System.out.println();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        int len = items.length;        
        int actual = (front + index) % len;
        if (index < 0 || actual >= len) {
            return null;
        }
        else return items[actual];
    }
}
