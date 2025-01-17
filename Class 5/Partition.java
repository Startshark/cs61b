public class Partition {
    public static int partition(int n, int m){
        if(n == m || m == 1) return 1;
        else if(m == 0 || n < m) return 0;
        else{
            return partition(n - 1, m - 1) + partition(n - m, m);
        }
    } 

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int count = partition(n, m);
        System.out.println("The total partition number is: " + count);
    }
}
