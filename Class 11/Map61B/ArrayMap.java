package Map61B;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;


public class ArrayMap<K, V> implements Map61B<K, V> {
    /** K & V are Generic type variables. */
    private K[] keys;
    private V[] values;
    private int size;

    public ArrayMap() {
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size = 0;
    }

    private int keyIndex(K key) {
        /** Return idx of the key if the key is in map, otherwise -1 */
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public boolean containsKey(K key) {
        int index = keyIndex(key);
        return index > -1;
    }

    public void put(K key, V val) {
        /** put a KV pair into the map. */
        // keys[size] = key;
        // values[size] = val;
        // size++;
        // Wrong! Because maybe we put a KV again in a map!

        int index = keyIndex(key);
        if(index == -1) {
            keys[size] = key;
            values[size] = val;
            size++;
            return;
        }
        values[index] = val;
    }

    public V get(K key) {
        /** Returns value, assuming key exists. */
        // for(int i = 0; i < size; i++) {
        //     if (keys[i].equals(key)) {
        //         return values[i];
        //     }
        // }
        // return null;
        int index = keyIndex(key);
        if(index == -1) {
            throw new IllegalArgumentException("The provided key " + key + " is not in ArrayMap.");
            // create new object of type IllegalArgumentException.  
        }

        return values[index];
        
    }

    public List<K> keys() {
        List<K> keylist = new ArrayList<>();
        for (K key: keys) {
            keylist.add(key);
        }
        return keylist;
    }

    public int size() {
        return size;
    }

    @Test
    public void test() { 
        ArrayMap<Integer, Integer> am = new ArrayMap<>();
        am.put(2, 5);
        int expected = 5;
        assertEquals(expected, (int)am.get(2)); // if not convert, this will be AssertEquals(int, Integer), ambiguous!
    }

    public static void main(String[] args) {
        ArrayMap<String, Integer> m = new ArrayMap<String,Integer>();
        m.put("horse", 3);
        m.put("fish", 9);
    }

}
