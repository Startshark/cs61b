public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int front;
    private int back;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        front = 0;
        back = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        /** Not quite right */
        int len = items.length;
        if (size == len) {
            T[] p = (T[]) new Object[2 * len];
            System.arraycopy(items, 0, p, 0, back + 1);
            if (front != 0) {
                System.arraycopy(items, front, p, len + front, len - front);
                front = len + front;
            }
            items = p;
        }
        else if (len >= 16 && size < len / 4) {
            T[] p = (T[]) new Object[len / 2];
            System.arraycopy(items, 0, p, 0, back + 1);
            if (front != 0) {
                System.arraycopy(items, front, p, front - len / 2, len - front);
                front = front - len / 2;
            }
            items = p;
        }
    }

    private int plus(int num) {
        return (num == items.length - 1) ? 0 : num + 1;
    }

    private int minus(int num) {
        return (num == 0) ? items.length - 1 : num - 1;
    }

    public void addFirst(T item) {
        resize();
        while (items[front] != null) {
            front = minus(front);
        }
        items[front] = item;
        size++;
    }

    public void addLast(T item) {
        resize();
        while (items[back] != null) {
            back = plus(back);
        }
        items[back] = item;
        size++;
    }

    public T removeFirst() {
        if (size <= 0) return null;

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

    public int size() {
        return size;
    }

    public T get(int index) {
        int len = items.length;        
        int actual = (front + index >= len) ? front + index - len : front + index;
        if (index < 0 || actual >= len) {
            return null;
        }
        else return items[actual];
    }
}
