package Map61B;

// import java.util.ArrayList;

import java.util.Iterator;


public class IterationDemo {
    public static void main(String[] args) {
        ArrayMap<String, Integer> am = new ArrayMap<>();

        am.put("hello", 5);
        am.put("syrups", 10);
        am.put("kingdom", 10);

        /** Even if Iterator method is private, you can still 
         *  access it in Arraymap.iterable() */
        Iterator<String> it = am.iterator(); 

        for (String s : am) {
            System.out.println(s);
        }
    }
}
