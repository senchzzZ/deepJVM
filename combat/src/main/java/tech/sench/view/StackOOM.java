package tech.sench.view;

/**
 * VMOption: -Xss1M
 * Created by zhaoshengqi on 2018/4/12.
 */
public class StackOOM {
    /*static {
        Byte[] bytes = new Byte[1024*20];

    }*/
    public void leak(){
        leak();
    }
    public static void main(String[] args) {
        StackOOM stackOOM = new StackOOM();
        stackOOM.leak();
        //stackOOM.createThread();
    }

    /*public void createThread(){
        for (;;){
            new Thread(()->{
                keepRunnig();
            }).start();
        }
    }*/

    public void keepRunnig(){
        for(;;);
    }
}
