import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {
    /** the syntax below helps Test the non-static function without main()*/
    @Test
    public void testSort(){
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};

        Sort.sort(input);
        
        assertArrayEquals(expected, input);
        
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

    @Test
    public void testfindSmallest(){
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;

        int actual = Sort.findSmallest(input, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void testSwap(){
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "have", "i", "egg"};

        Sort.swap(input, 0, 2);
        
        assertArrayEquals(expected, input);
    }

    /** Test-Driven Development 
     * Tests provide stability and scaffolding,
     * it helps you focus on one task at a time.
     * Tests also allow you to safely refractor in larger proj!
     */

    // public static void main(String[] args) {
    //     testSort();
    //     testfindSmallest(); 
    //     testSwap();
    // }
}
