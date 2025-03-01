import java.util.ArrayDeque;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        String[] failure = new String[1001];
        int count = 0;

        for (int i = 0; i < 1000; i++) {
            System.out.println("The " + String.valueOf(i) + " times testing:");
            System.out.flush();

            int randomNumber = StdRandom.uniform(4);

            if (randomNumber == 0) {
                int randomValue = StdRandom.uniform(100);
                sad.addLast(randomValue);
                ad.addLast(randomValue);
                failure[count] = "addLast(" + randomValue+ ")";
                count++;
            } 
            else if (randomNumber == 1) {
                int randomValue = StdRandom.uniform(100);
                sad.addFirst(randomValue);
                ad.addFirst(randomValue);
                failure[count] = "addFirst(" + randomValue+ ")";
                count++;
            } 
            
            else if (randomNumber == 2) {
                if (!sad.isEmpty()) {
                    System.out.println("removeFirst called!");
                    System.out.flush();
                    Integer expected = ad.removeFirst();
                    Integer actual = sad.removeFirst();
                    failure[count] = "removeFirst()";

                    System.out.println("actual is " + actual);
                    System.out.flush();

                    if(count >= 2) {
                        assertEquals(failure[count - 2] + '\n' + failure[count - 1] + '\n' + failure[count], expected, actual);
                    }
                    else {
                        assertEquals(failure[count - 1] + '\n' + failure[count], expected, actual);
                    }
                    count++;
                }
            } 
            else if (randomNumber == 3) {
                if (!sad.isEmpty()) {
                    System.out.println("removeLast called!");
                    System.out.flush();
                    Integer expected = ad.removeLast();
                    Integer actual = sad.removeLast();
                    failure[count] = "removeLast()";

                    System.out.println("actual is " + actual);
                    System.out.flush();

                    if(count >= 2) {
                        assertEquals(failure[count - 2] + "\n" + failure[count - 1] + "\n" + failure[count], expected, actual);
                    }
                    else {
                        assertEquals(failure[count - 1] + "\n" + failure[count], expected, actual);
                    }
                    count++;
                }
            }
        }
    }

}
