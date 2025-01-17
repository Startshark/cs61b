public class SLList {
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

    private IntNode first;
    
    public SLList(int x){
        first = new IntNode(x, null); // Caution!
    }

    public void addFirst(int x){
        first = new IntNode(x, first);
    }

    public int getFirst(){
        return first.item;
    }

    public static void main(String[] args) {
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        System.out.println(L.getFirst());
    }
}
