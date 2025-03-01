import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByN = new OffByN(5);

    // Your tests go here.
    @Test
    public void testequalChars() {
        Character a = 'a';
        Character b = 'f';
        assertTrue(offByN.equalChars(a, b));

        a = 'f';
        b = 'a';
        assertTrue(offByN.equalChars(a, b));

        Character c = 'f';
        Character d = 'h';
        assertFalse(offByN.equalChars(c, d));
    }
}
