/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();
        /* 
        CharacterComparator cc = new OffByOne();

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
                System.out.println(word);
            }
        } */
        int max_index_of_N = 0;
        int max_count_of_N = 0;
        String[] len_N = new String[27];

        for(int i = 1; i < 26; i++){
            CharacterComparator cc = new OffByN(i);

            // 每次循环都需要更新 in，因为每次循环都需要从头开始读取 words.txt 文件
            in = new In("../library-sp18/data/words.txt");

            int count = 0;
            int maxlen = 0;
            while (!in.isEmpty()) {
                String word = in.readString();
                if (word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
                    count++;
                    // System.out.println(word);
                    if (word.length() > maxlen) {
                        maxlen = word.length();
                        len_N[i] = word;
                    }
                }
            }
            if (count > max_count_of_N) {
                max_index_of_N = i;
                max_count_of_N = count;
            }
        }

        System.out.println("For " + String.valueOf(max_index_of_N) + " there are the most palindromes with the count of " + String.valueOf(max_count_of_N));
        
        System.out.println("The longest in OffByN:");
        for(int i = 1; i < 26; i++) {
            System.out.println("For N = " + String.valueOf(i) + " is: " + len_N[i]);    
        }
    }
}

/**
 * For 4 there are the most palindromes with the count of 115
The longest in OffByN:
For N = 1 is: chrysid
For N = 2 is: costume
For N = 3 is: borehole
For N = 4 is: heapstead
For N = 5 is: interjoin
For N = 6 is: knopite
For N = 7 is: reimply
For N = 8 is: fieldman
For N = 9 is: difform
For N = 10 is: overholy
For N = 11 is: gladiolar
For N = 12 is: mahatma
For N = 13 is: garment
For N = 14 is: arado
For N = 15 is: tepetate
For N = 16 is: bedur
For N = 17 is: arear
For N = 18 is: gansy
For N = 19 is: about
For N = 20 is: durax
For N = 21 is: valva
For N = 22 is: wawa
For N = 23 is: null
For N = 24 is: yaya
For N = 25 is: Tzaam
 */