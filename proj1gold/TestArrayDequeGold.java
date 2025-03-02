import java.util.ArrayDeque;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        String message = "";

        for (int i = 0; i < 1000; i++) {
            // System.out.println("The " + String.valueOf(i) + " times testing:");
            // System.out.flush();

            int randomNumber = StdRandom.uniform(4);

            if (randomNumber == 0) {
                int randomValue = StdRandom.uniform(100);
                sad.addLast(randomValue);
                ad.addLast(randomValue);
                message += ("addLast(" + randomValue + ")\n");
            } 
            else if (randomNumber == 1) {
                int randomValue = StdRandom.uniform(100);
                sad.addFirst(randomValue);
                ad.addFirst(randomValue);
                message += ("addFirst(" + randomValue + ")\n");
            } 
            
            else if (randomNumber == 2) {
                if (!sad.isEmpty()) {
                    // System.out.println("removeFirst called!");
                    // System.out.flush();
                    Integer expected = ad.removeFirst();
                    Integer actual = sad.removeFirst();
                    message += "removeFirst()\n";
                    assertEquals(message, expected, actual);
                }
            }
            else if (randomNumber == 3) {
                if (!sad.isEmpty()) {
                    // System.out.println("removeLast called!");
                    // System.out.flush();
                    Integer expected = ad.removeLast();
                    Integer actual = sad.removeLast();
                    message += "removeLast()\n";
                    assertEquals(message, expected, actual);
                }
            }
        }
    }

}
