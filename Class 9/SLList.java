import java.util.NoSuchElementException;

public class SLList<Item>{
    /** Put any name in <> you like as Template! */
    private class StaffNode {
        public Item item;
        public StaffNode next;
        public StaffNode(Item i, StaffNode n){
            item = i;
            next = n;
        }
    }

    private StaffNode sentinel;
    private int size = 0;
    private Item dummy;
    
    public SLList(){ 
        sentinel = new StaffNode(dummy, null);
        size = 0;
    }

    public SLList(Item x){
        sentinel = new StaffNode(dummy, null);
        sentinel.next = new StaffNode(x, null);
        size = 1;
    }

    public void addFirst(Item x){
        sentinel.next = new StaffNode(x, sentinel.next); 
        size += 1;
    }

    public Item getFirst(){
        return sentinel.next.item;
    }

    public void addLast(Item x){
        size += 1;
        StaffNode p = sentinel;
        while(p.next != null){
            p = p.next;
        }
        p.next = new StaffNode(x, null);
    }

    public int size(){
        return size;
    }

    public Item get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        StaffNode current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    public void insert(Item item, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        StaffNode current = sentinel;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        current.next = new StaffNode(item, current.next);
        size++;
    }

    public Item removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        StaffNode current = sentinel;
        while (current.next.next != null) {
            current = current.next;
        }
        Item item = current.next.item;
        current.next = null;
        size--;
        return item;
    }

    public Item getLast() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        StaffNode current = sentinel;
        while (current.next != null) {
            current = current.next;
        }
        return current.item;
    }

    public void print() {
        StaffNode current = sentinel.next;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;        
        }
    }

        public static void main(String[] args) {
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(17);
        System.out.println(L.getFirst());
        System.out.println(L.size());
    }
}
