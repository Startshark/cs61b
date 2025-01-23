import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {
    @Test
    public void isSameNumberTest(){
        int a = 0, b = 0;
        assertTrue(Flik.isSameNumber(a, b));

        a = 127;
        b = 127;
        assertTrue(Flik.isSameNumber(a, b));

        int c = 128;
        int d = 128;
        assertTrue(Flik.isSameNumber(c, d));

        b = 9999;
        assertFalse(Flik.isSameNumber(a, b));
    }

    public static void main(String... args) {
        jh61b.junit.TestRunner.runTests("all", FlikTest.class);
    }

}

