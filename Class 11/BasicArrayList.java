import java.util.ArrayList;

public class BasicArrayList {
    public static void main(String[] args) {
        /** ArrayList<int> L = new ArrayList<>(); (x)
         * primitive type is not allowed in collections
         * because null not in primitive! */
        ArrayList<Integer> L = new ArrayList<>();
        L.add(5); // Autoboxing, equals to L.add(new Integer(5))
        L.add(6);
        int first = L.get(0);
        System.out.println(first);
    }

    public class Date {
        /** Immutable Data Types, cannot change since instantiated. */
        public final int month;
        public final int day;
        public final int year;
        private boolean contrived = true;
        public Date (int m, int d, int y) {
            month = m;
            day = d;
            year = y;
        }
    }
}