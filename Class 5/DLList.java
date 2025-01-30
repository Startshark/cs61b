public class DLList {
    /** Doubly linked list */
    private static class IntNode {
        /** Nested class definition, we can put it front conventionally. 
         * 
         * "static" means the class IntNode never looks out the closure 
         *     for the variables like "first". 
         *     We can save memory by use it.
        */
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }
    /** It might be bad to add .last and .prev 
     * for tons of special cases though fast. 
     * 1) We can have two Sentinels for convinence. 
     * 2) Even better, we can have a circular sentinel. */

    private IntNode sentinel;
    private int size;
    private IntNode last;

    public DLList(){
        sentinel = new IntNode(63, null);
        last = sentinel;
        size = 0;
    }

    public DLList(int x){
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        // sentinel.next.next = sentinel;
        last = sentinel.next;
        size = 1;
    }

    public void addLast(int x){
        last.next = new IntNode(x, null);
        last = last.next;
        size += 1;
    }

}
