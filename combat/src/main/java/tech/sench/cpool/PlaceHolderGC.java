package tech.sench.cpool;

/**
 * 内存占用
 * Created by zhaoshengqi on 2018/6/7.
 */
public class PlaceHolderGC {
    public static void main(String[] args) {
        //placeholder原本所占用的Slot还没有被其他变量所复用，所以作为GC Roots一部分的局部变量表仍然保持着对它的关联
        {
            byte[] placeholder = new byte[1024*1024*64];
            //placeholder = null;
        }
        //int i = 0;
        System.gc();
    }
}
