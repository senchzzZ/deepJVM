package tech.sench.view;

import java.util.ArrayList;
import java.util.List;

/**
  G1:
 -XX:+UseG1GC
 -XX:MetaspaceSize=1M
 -XX:MaxMetaspaceSize=10M
 -XX:+PrintGCDetails

 -XX:PermSize=5M
 -XX:MaxPermSize=5M

 * Created by zhaoshengqi on 2018/4/12.
 */
public class ConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        for (int i=0;;){
            list.add(String.valueOf(i).intern());
        }
    }
}
