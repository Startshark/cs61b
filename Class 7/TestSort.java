public class TestSort {
    /** Test the Sort.sort method. */
    public static void testSort(){
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};

        Sort.sort(input);
        
        org.junit.Assert.assertArrayEquals(expected, input);
        
        /** Ad Hoc Test, not so good. */
        // for(int i = 0; i < input.length; i++){
        //     if(!input[i].equals(expected[i])){
        //         System.out.println("Mismatch in position " + i + ", expected: " + expected[i] + ", but got: " + input[i]);
        //         return;
        //     }
        // }

        // if(!java.util.Arrays.equals(input, expected)){
        //     System.out.println("Error Sort!");
        // }
    }

    public static void testfindSmallest(){
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;

        int actual = Sort.findSmallest(input, 2);
        org.junit.Assert.assertEquals(expected, actual);
    }

    public static void testSwap(){
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "have", "i", "egg"};

        Sort.swap(input, 0, 2);
        
        org.junit.Assert.assertArrayEquals(expected, input);
    }

    public static void main(String[] args) {
        /** Tests provide stability and scaffolding,
         * it helps you focus on one task at a time.
         * Tests also allow you to safely refractor in larger proj!
         */
        testSort();
        testfindSmallest(); 
        testSwap();
    }
}
