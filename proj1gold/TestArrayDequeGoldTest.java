import java.util.ArrayDeque;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDequeGoldTest {

    @Test
    public void testProvidedFailureCase() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        sad.addLast(18);
        ad.addLast(18);

        Integer expected1 = ad.removeLast();
        Integer actual1 = sad.removeLast();
        assertEquals(expected1, actual1);

        boolean sadIsEmpty = sad.isEmpty();
        boolean adIsEmpty = ad.isEmpty();
        assertEquals(adIsEmpty, sadIsEmpty);

        if (!sad.isEmpty()) {
            Integer expected2 = ad.removeLast();
            Integer actual2 = sad.removeLast();
            assertEquals(expected2, actual2);
        } else {
            Integer expected2 = null;
            Integer actual2 = sad.removeLast();
            assertEquals(expected2, actual2);
        }
    }

    @Test
    public void testAddRemove() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        sad.addFirst(10);
        ad.addFirst(10);
        assertEquals(ad.removeFirst(), sad.removeFirst());

        sad.addLast(20);
        ad.addLast(20);
        assertEquals(ad.removeLast(), sad.removeLast());
    }

    @Test
    public void testIsEmpty() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        assertEquals(ad.isEmpty(), sad.isEmpty());

        sad.addFirst(10);
        ad.addFirst(10);
        assertEquals(ad.isEmpty(), sad.isEmpty());

        sad.removeFirst();
        ad.removeFirst();
        assertEquals(ad.isEmpty(), sad.isEmpty());
    }
}