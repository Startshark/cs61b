public class Hello{
    /** Returns the Larger of x and y. */
    public static int larger(int x, int y){
        if(x > y){
            return x;
        }
        return y;
    }
    public static void main(String[] args){
        System.out.println("你好啊！");
        System.out.println(larger(-5, 10));
        // for (int i = 0 ; i < 10; i++) {
        //     System.out.println(i);   
        // }
    }
}