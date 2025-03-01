import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testequalChars() {
        Character a = 'a';
        Character b = 'b';
        assertTrue(offByOne.equalChars(a, b));

        a = 'b';
        b = 'c';
        assertTrue(offByOne.equalChars(a, b));

        a = ' ';
        b = ' ';
        assertFalse(offByOne.equalChars(a, b));

        a = 'a';
        b = 'A';
        assertFalse(offByOne.equalChars(a, b));

        Character c = 'r';
        Character d = 'l';
        assertFalse(offByOne.equalChars(c, d));
    }
}
