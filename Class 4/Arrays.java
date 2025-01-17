public class Arrays {
    public static void main(String[] args) {
        // Declaration is create a box for 64 bits address, nothing instantiated. "int[] a" 
        // Instantiation is create a object. "new int[]{0, 1, 2, 95, 4}"
        // Assignment is copy the address of the object to the box "="
        int[] a = new int[]{0, 1, 2, 95, 4};

        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L); // this is inversed! 15 -> 10 -> 5
        
        System.out.println(L.size());
        System.out.println(L.iterativeSize());
        System.out.println(L.get(2));
        System.out.println(L.iterativeGet(1));
    }

    public static class IntList{
        /** Different from the built-in array, this list is able to expanded arbitarily. */
        public int first;
        public IntList rest; // Similar to the LinkedList in Java
        
        public IntList(int f, IntList r) {
            first = f;
            rest = r;
        }

        public int size(){
            /** Return the size of the list using recursion! */
            if (rest == null) {
                return 1;
            }
            return 1 + rest.size();
        }

        public int iterativeSize(){
            /** Return the size of the list using iteration! */
            IntList p = this;
            int totalSize = 0;
            while (p != null) { // use loop
                totalSize += 1;
                p = p.rest;
            }
            return totalSize;
        }

        public int get(int i){
            assert(i >= 0);
            if(i == 0){
                return first;
            }
            else{
                return rest.get(i - 1);
            }
        }

        public int iterativeGet(int i){
            assert(i >= 0);
            IntList tmp = this;
            while(i > 0){
                tmp = tmp.rest;
                i -= 1;
            }
            return tmp.first;
        }
    }
}
