public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque<>();
        for (Character c: word.toCharArray()) {
            d.addLast(c);
        }
        return d;
    }

    private boolean isPalindrome_helper(Deque<Character> d){
        if (d.size() <= 1) {
            return true;
        }
        return d.removeFirst().equals(d.removeLast()) && isPalindrome_helper(d);
    } 

    public boolean isPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        return isPalindrome_helper(d);
    }


    /** Overloading */
    private boolean isPalindrome_helper(Deque<Character> d, CharacterComparator cc){
        if(d.size() <= 1) {
            return true;
        }
        return cc.equalChars(d.removeFirst(), d.removeLast()) && isPalindrome_helper(d, cc);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);
        return isPalindrome_helper(d, cc);
    }
}
