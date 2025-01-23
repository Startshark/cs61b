public class SLList {
    /** SLLists class acts as a middle man between user and the naked recursive data structure. */
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

    /** The first item(if it exists) is at sentinel.next */
    // private IntNode first;
    private IntNode sentinel;
    private int size = 0; // achieve size in constant time
    
    public SLList(){ 
        /** Creates an empty SLList. */
        sentinel = new IntNode(-1, null); // Any number you like.
        size = 0;
    }

    public SLList(int x){
        sentinel = new IntNode(-1, null);
        sentinel.next = new IntNode(x, null);
        // first = new IntNode(x, null); // Caution!
        size = 1;
    }

    public void addFirst(int x){
        // We can't modify sentinel but sentinel.next
        sentinel.next = new IntNode(x, sentinel.next); 
        size += 1;
    }

    public int getFirst(){
        // return first.item;
        return sentinel.next.item;
    }

    public void addLast(int x){
    /** We can avoid special case by make all SLLists
     * (even empty) the "same". 
     * We can add a Sentinel Node(dummy) at the front of the list.
     */
        
    // IntNode head = first;
    // while(first.next != null){
    //     first = first.next;
    // }
    // first.next = new IntNode(x, null);
    // first = head;

        size += 1;

        IntNode p = sentinel;
        
        /** A not-so-good corner case adjustment. */
        // if(first == null){
        //     first = new IntNode(x, null);
        //     return;
        // }

        while(p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    // private static int size(IntNode p){
    //     /** Returns the size of the list that starts at p. */
    //     if(p.next == null){
    //         return 1;
    //     }
    //     return size(p.next) + 1;
    // }

    // public int size(){
    //     /** We say that two methods with the same name 
    //      * but different signatures are overloaded. */
    //     return size(first);
    // }

    public int const_time_size(){
        return size;
    }
    
    public static void main(String[] args) {
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(17);
        System.out.println(L.getFirst());
        // System.out.println(L.size());
        System.out.println(L.const_time_size());
    }
}
