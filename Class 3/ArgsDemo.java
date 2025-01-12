public class ArgsDemo {
    /** Prints out the 0th command line argument. */
    public static void main(String[] args) {
        // System.out.println(args[0]);
        int N = args.length;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(args[i]);
        }
        System.out.println(sum);
    }
    
}
