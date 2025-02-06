public class ArrayDeque<T>{
    private T[] items;
    private int size;
    private int front;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        front = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void resize(){
        /** Not quite right */
        int len = items.length;
        if(size == len){
            T[] p = (T[]) new Object[2 * len];
            System.arraycopy(items, 0, p, 0, size);
            items = p;
        }
        else if(len >= 16 && size < len / 4){
            T[] p = (T[]) new Object[len / 2];
            System.arraycopy(items, 0, p, 0, size);
            items = p;
        }
    }

    public void addFirst(T item){
        resize();
    }

    public void addLast(T item){
        resize();
        
        items[size - front] = item;
        size++;
    }

}