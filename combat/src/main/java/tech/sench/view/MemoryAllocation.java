package tech.sench.view;

/**
 *
 * -verbose:gc
 -Xms20M
 -Xmx20M
 -Xmn5M
 -XX:+PrintGCDetails
 -XX:SurvivorRatio=8
 * Created by zhaoshengqi on 2018/4/13.
 */
public class MemoryAllocation {
    public static void main(String[] args) {
        byte[] allocation0,allocation1,allocation2,allocation3;

        allocation0 = new byte[2*1024*1024];
        allocation1 = new byte[3*1024*1024];
        allocation2 = new byte[3*1024*1024];
        allocation3 = new byte[4*1024*1024];

    }
}
