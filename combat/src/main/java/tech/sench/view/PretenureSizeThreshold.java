package tech.sench.view;

/**
 * 对象超出直接进入老年代
  -XX:+UseParNewGC //Parallel Scavenge 不识别PretenureSizeThreshold参数
  -XX:PretenureSizeThreshold=2097152 //不能使用2M
  -verbose:gc
  -Xms20M
  -Xmx20M
  -Xmn10M
  -XX:+PrintGCDetails
  -XX:SurvivorRatio=8
 *
 * Created by zhaoshengqi on 2018/4/13.
 */
public class PretenureSizeThreshold {
    public static void main(String[] args) {
        byte[] allocation0 = new byte[3*1024*1024];
    }
}
