public class testDemo {
    public static void main(String[] args) {
        List61B<String> L = new SLList<>();
        /** List61B is the static type, 
         * and SLList is the run-time type
         * It works well! */
        L.addFirst("Hello");
        L.addLast("World");
        L.print();
    }
}

/** But remember, we specify "is-a" relationships, not "has-a" 
 *  Good: Dog implements Animal, SLList "is a" List61B
 *  Bad: Cat implements Claw
 */
