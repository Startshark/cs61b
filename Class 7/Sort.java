public class Sort {
    /** Sorts strings destructively. */
    public static void sort(String[] x){
        sort(x, 0);
    }

    /** Sorts x starting at position start. */
    private static void sort(String[] x, int start){
        if(start == x.length - 1) return;
        int smallestIndex = findSmallest(x, start);
        swap(x, start, smallestIndex);
        sort(x, start + 1);
    }

    /** Return index */
    public static int findSmallest(String[] x, int start){
        int smallestIndex = start;
        for(int i = start; i < x.length; i++){
            if(x[i].compareTo(x[smallestIndex]) < 0){
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void swap(String[] x, int a, int b){
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

    public static void SelectionSort(int[] x){
        int l = x.length;
        for(int i = 0; i < l; i++){
            int min_index = i;
            for(int j = i + 1; j < l; j++){
                if(x[j] < x[min_index]){
                    min_index = j;
                }
            }
            int tmp = x[i];
            x[i] = x[min_index];
            x[min_index] = tmp;
        }
    }
    
    // public static void main(String[] args) {
    //     int[] x = {1, 5, 4, 9, 20};
    //     int[] expected = {1, 4, 5, 9, 20};
    //     SelectionSort(x);
    //     org.junit.Assert.assertArrayEquals(expected, x);
    //     System.out.println("OK!");
    // }
}
