public interface List61B<Item> {
    // Overriding Inheritance do not change the parameters type and return type!
    // Overloading has different signature!

    /** Just tell what the subclass can do but not how.
     *  Subclass must overirdes all the methods in the interface.
     */


    // no private method in interface !!!

    public void addFirst(Item x);

    /** Inserts X into the back of the list. */
    public void addLast(Item x);

    /** Returns the item from the front of the list. */
    public Item getFirst();

    /** Returns the item from the back of the list. */
    public Item getLast();
    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i);

    /** Returns the number of items in the list. */
    public int size();

    /** Deletes item from back of the list and
      * returns deleted item. */
    public Item removeLast();

    public void insert(Item x, int position);

    /** Prints out the entire list */
    default public void print(){
      /** Implementation Inheritance */
      for(int i = 0; i < size(); i+=1){
        // efficient for Alist and inefficient for SLList(hard to get)
        System.out.print(get(i) + " "); 
      }
      System.out.println();
    }
}
