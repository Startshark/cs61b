public class Maximizer {
    public static Comparable max(Comparable[] items) {
        /** Never get wrong because it is good in static view. */
        int maxIndex = 0;
        for (int i = 0; i < items.length; i++) {
            int cmp = items[i].compareTo(items[maxIndex]);
            if (cmp > 0) {
                maxIndex = i;
            }
        }
        return items[maxIndex];
    }
}
