import org.junit.Test; 
import static org.junit.Assert.*;

public class ArrayDequeTest { 
    @Test 
    public void checkEmpty() { 
        ArrayDeque<String> ad = new ArrayDeque<>(); 
        assertTrue(ad.isEmpty()); 
    }

    @Test 
    public void checkAdd() { 
        ArrayDeque<String> ad
        ArrayDeque<String> ad = new ArrayDeque<>();

        ad.addFirst("Loufey");
        int size = ad.size();
        assertEquals(1, size);

        ad.addFirst("like");
        ad.addFirst("I");
        ad.printDeque();
        size = ad.size();
        assertEquals(3, size);

        ad.addLast("when");
        ad.addLast("she");
        ad.addLast("smiles");
        size = ad.size();
        assertEquals(6, size);

        ad.printDeque();
    }
    
    @Test
    public void checkRemove() {
        /*****************************/
        ArrayDeque<String> ad = new ArrayDeque<>();

        ad.addFirst("Loufey");
        ad.addFirst("like");
        ad.addFirst("I");

        ad.addLast("when");
        ad.addLast("she");
        ad.addLast("smiles");
        
        /*****************************/

        String smiles = ad.removeLast();
        String she = ad.removeLast();
        String when = ad.removeLast();
        ad.printDeque();
        assertEquals("when", when);

        ad.removeFirst();
        int size = ad.size();
        assertEquals(2, size);
    }

    @Test
    public void checkGet() {
        /*****************************/
        ArrayDeque<String> ad = new ArrayDeque<>();
        
        ad.addFirst("Loufey");
        ad.addFirst("like");
        ad.addFirst("I");

        ad.addLast("when");
        ad.addLast("she");
        ad.addLast("smiles");
        
        /*****************************/

        String Loufey = ad.get(2);
        assertEquals("Loufey", Loufey);

        String nothing = ad.get(6);
        assertNull(nothing);

        nothing = ad.get(-100);
        assertNull(nothing);
    }

    @Test
    public void checkResize() {
        /*****************************/
        ArrayDeque<String> ad = new ArrayDeque<>();
        
        ad.addFirst("Loufey");
        ad.addFirst("like");
        ad.addFirst("do");
        ad.addFirst("I");

        ad.addLast("when");
        ad.addLast("she");
        ad.addLast("smiles");
        ad.addLast("at");

        ad.printDeque();
        /*****************************/
    
        // resize happen:
        ad.addLast("me");

        ad.printDeque();

        ad.removeLast();
        ad.removeLast();
        ad.removeFirst();
        ad.removeFirst();
        ad.removeFirst();

        // resize happen: 
        ad.removeLast();
        ad.printDeque();

    }

    @Test
    public void checkFull2Empty(){
        /*****************************/
        ArrayDeque<String> ad = new ArrayDeque<>();

        ad.addFirst("Loufey");

        ad.addLast("smiles");

        // ad.printDeque();
        /*****************************/
        
        ad.removeLast();
        ad.removeLast();

        assertTrue(ad.isEmpty());
        
        ad.printDeque();

        for(int i = 0; i < 20; i++){
            ad.addLast("Loufey");

            ad.addLast("smiles");

            ad.addLast("at");

            ad.printDeque();
        }


        for(int i = 0; i < 44; i++){
            ad.removeFirst();
        }

        ad.printDeque();

    }
}
