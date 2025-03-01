/** Array based list.
 *  @author Josh Hug
 */

public class AList<Item> implements List61B<Item> {
    /** implements tells Java compiler that AList is a hyponym of LIST61B */

    /** Similar to generic SLists */
    private Item[] items;
    private int size;
    private int max_length = 100; // items.length
    /** Creates an empty list. */
    public AList() {
        /** Length less than 100 is OK. */
        // items = new Item[max_length];  Generic Array is not allowed.
        items = (Item[]) new Object[100]; // cast
        size = 0;
    }

    /** Resizes the Underlying array to the target capacity. */
    private void resize(int capacity){
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        // System.out.println(a.length);
        items = a;
    }

    /** Inserts X into the back of the list. */
    public void addLast(Item x) {
        /** Array Resizing can be done in a separate function. */
        if(size == items.length){ 
            resize(size * 2); // faster than "size + 1"      
        }
        items[size++] = x;
    }

    /** Returns the item from the front of the list. */
    public Item getFirst() {
        return items[0];
    }

    /** Returns the item from the back of the list. */
    public Item getLast() {
        return items[size - 1];        
    }
    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i) {
        return items[i];        
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;        
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public Item removeLast() {
        // return items[--size];
        /** Nulling out Deleted Items 
         * Save Memory, don't loiter.
        */
        Item returnItem = getLast();
        items[size - 1] = null;
        size -= 1;
        return returnItem;
    }
    
    /** Inserts X into the list at the given position. */
    @Override
    public void insert(Item x, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        if (size == items.length) {
            resize(size * 2);
        }
        System.arraycopy(items, position, items, position + 1, size - position);
        items[position] = x;
        size++;
    }
    
    /** Inserts X into the front of the list. */
    @Override
    public void addFirst(Item x) {
        insert(x, 0);
    }
} 