import java.io.IOException;

public class ExceptionDemo {
    public static void gulgate() {
        String today = "Thursday";
        try {
            if (today == "Thursday") {
                throw new IOException("hi"); 
            }
        } catch (Exception e) {
            /** IOException is a checked exceptions, 
             *  unlike RuntimeException, so you need to (1) Catch it: */
            System.out.println("psych!");
            System.out.println(e);
        }
    }

    /** Or (2) Specify methods as dangerous with keyword "throws" 
     * But itself becomes dangerous, main don't complie it.
    */
    public static void gulgate2() throws IOException {
        String today = "Thursday";
        if (today == "Thursday") {
            throw new IOException("hi"); 
        }

    }

    public static void gulgate3() {
        /** RuntimeException is unchecked Exception! 
         *  Because it's usually unpredictable for cast! */
        String today = "Thursday";
        if (today == "Thursday") {
            throw new RuntimeException("For no reason."); 
        }
    }

    public static void main(String[] args) {
        gulgate();
        
        gulgate2();

        // Specify main is dangerous. Use when someone else should handle.
        // public static void main(String[] args) throws IOException {
        //     throws IOException {
        //       gulgate();
        //     }
        // }

        gulgate3();
    }
}
