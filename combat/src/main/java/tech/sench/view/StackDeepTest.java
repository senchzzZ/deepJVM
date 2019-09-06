package tech.sench.view;

/**
 * -Xss128k
 * Created by zhaoshengqi on 2019/8/16.
 */
public class StackDeepTest {
    private static int count;

    public static void main(String[] args) {
        try {
            //recurse(1,2,3);
            recurse();
        } catch (Throwable e){
            System.out.println("deep of calling : " + count);
            e.printStackTrace();
        }
    }

    public static void recurse(long a, long b, long c){
        double d,e,f,g,h,j,k,l = 1000;
        count++;
        recurse(a, b, c);
    }

    public static void recurse(){
        count++;
        recurse();
    }
}
