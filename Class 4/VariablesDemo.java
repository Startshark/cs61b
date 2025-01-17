public class VariablesDemo {
    public static void main(String[] args) {
        /** Golden Rule of x equal y is copying bits of y to x. Also applies to pass parameter. */
        int x = 5;
        int y;
        y = x;
        x = 2;
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        // The change on x will not affect y

        Walrus a = new Walrus(1000, 8.3);
        Walrus b;
        b = a;
        b.weight = 5;
        System.out.println(a);
        System.out.println(b);
        // b = a implies that b is pointing to the same Walrus
        // We can think of "new Walrus(1000, 8.3)" return a address of the first bit of the object
        // When we declare a variable of reference type, Java return a 64 bits address
    }

    public static class Walrus {
        public int weight;
        public double tuskSize;
        
        public Walrus(int w, double ts) {
           weight = w;
           tuskSize = ts;
        }
  
        public String toString() {
           return String.format("weight: %d, tusk size: %.2f", weight, tuskSize);
        }
     }
}


/* 8 primitive types in Java: byte, short, int, long, float, double, boolean, char 
 * Everything else, including arrays, is a reference type.
 * 
*/