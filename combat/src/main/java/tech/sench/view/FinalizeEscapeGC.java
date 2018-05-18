package tech.sench.view;


/**
 * 对象自救
 * Created by zhaoshengqi on 2018/5/11.
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC INSTANCE = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        INSTANCE = this;
    }

    public static void main(String[] args) throws InterruptedException {
        INSTANCE = new FinalizeEscapeGC();

        //对象在finalize自救成功
        INSTANCE = null;
        System.gc();
        Thread.sleep(500);

        isAlive();

        //对象自救失败（finalize只能被成功执行一次）
        INSTANCE = null;
        System.gc();
        Thread.sleep(500);

        isAlive();

    }

    public static void isAlive(){
        if (INSTANCE == null){
            System.out.println("dead");
        }else {
            System.out.println("alive");
        }
    }
}
