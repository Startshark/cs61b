public class TimeAnalysis {
    //Silly Duplicate: compare everything
    public static boolean dup1(int[] A) {  
        for (int i = 0; i < A.length; i += 1) {
            for (int j = i + 1; j < A.length; j += 1) {
                if (A[i] == A[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    
    //Better Duplicate: compare only neighbors
    public static boolean dup2(int[] A) {
        for (int i = 0; i < A.length - 1; i += 1) {
            if (A[i] == A[i + 1]) { 
                return true; 
            }
        }
        return false;
    }

    public static int[] makeArray(int N) {
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = i;
        }
        return A;
    }

    public static void main(String args[]) {
        int N = Integer.parseInt(args[0]);
        int[] A = makeArray(N);
        dup2(A);
    }
}