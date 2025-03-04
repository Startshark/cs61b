package Map61B;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

/**
 * Class to demonstrate how generic methods work in Java.
 */
public class MapHelper {
    /* Write the following three methods:
    /* get(Key) : Return item in map if it exists. */
    /* maxKey() : Returns max of all keys. Works only if x and y have comparable data. */
    /* allBark(): Makes all keys bark, but only works for Dogs. */

    public static <K, V> V get (Map61B<K, V> sim, K key) {
        /** This time the generic <K, V> only applies to this generic method. */
        if (sim.containsKey(key)) {
            return sim.get(key);
        }
        return null;
    }

    public static <K extends Comparable<K>, V> K maxKey(Map61B<K, V> map) {
        /** Here "extends" is more like a definition rather than completation,
         * it's a type upper bound, ensuring the generic type has some specific traits.
         */
        List<K> keylist = map.keys();
        K largest = keylist.get(0);
        for (K k: keylist) {
            if (k == null) {
                break;
            }
            if (k.compareTo(largest) > 0) {
                largest = k;
            }
        }
        return largest;
    }



    @Test
    public void testGet() {
        Map61B<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);

        Integer actual = MapHelper.get(m, "fish");
        Integer expected = 9;
        assertEquals(expected, actual);
    }

    @Test
    public void testMaxKey() {
        Map61B<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);

        String actual = MapHelper.maxKey(m);
        String expected = "house";
        assertEquals(expected, actual);
    }    
}