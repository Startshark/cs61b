import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        Boolean a = palindrome.isPalindrome("a");
        assertEquals(true, a);

        Boolean b = palindrome.isPalindrome("racecar");
        assertEquals(true, b);

        Boolean c = palindrome.isPalindrome("rancar");
        assertEquals(false, c);
    }

    @Test
    public void testisOnePalindrome() {
        CharacterComparator cc = new OffByOne();
        Boolean a = palindrome.isPalindrome("a", cc);
        assertTrue(a);

        Boolean b = palindrome.isPalindrome("racedbq", cc);
        assertTrue(b);

        Boolean c = palindrome.isPalindrome("rannar", cc);
        assertFalse(c);

        Boolean d = palindrome.isPalindrome("raceabq", cc);
        assertFalse(d);
    }

    @Test
    public void testisNPalindrome() {
        CharacterComparator cc = new OffByN(5);
        Boolean a = palindrome.isPalindrome("a", cc);
        assertTrue(a);

        Boolean b = palindrome.isPalindrome("rachfm", cc);
        assertTrue(b);

        Boolean c = palindrome.isPalindrome("rannar", cc);
        assertFalse(c);

        Boolean d = palindrome.isPalindrome("racyfm", cc);
        assertFalse(d);
    }
}
