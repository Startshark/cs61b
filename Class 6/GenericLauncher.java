public class GenericLauncher {
    public static void main(String[] args) {
        Generic<String> s1 = new Generic<>("bone");
        s1.addFirst("thugs");

        Generic<Integer> s2 = new Generic<>(15);
        s2.addFirst(10);
    }
}
