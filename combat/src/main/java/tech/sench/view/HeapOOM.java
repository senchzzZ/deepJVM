package tech.sench.view;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * VMOption: -Xms10M -Xmx10M -XX:+PrintGCDetails -XX:+UseG1GC
 * Created by zhaoshengqi on 2018/4/12.
 */
public class HeapOOM {
    public static void main(String[] args) throws InterruptedException {
        List lis = new ArrayList();
        for (;;){
            lis.add(new Object());
            //TimeUnit.MILLISECONDS.sleep(100);
        }
    }
}
