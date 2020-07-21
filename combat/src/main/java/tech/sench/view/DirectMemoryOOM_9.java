package tech.sench.view;






import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * java9+直接内存溢出
 * 停止后才会报OpenJDK 64-Bit Server VM warning: Exception java.lang.OutOfMemoryError occurred dispatching signal SIGINT to handler- the VM may need to be forcibly terminated
 * -Xmx2M -XX:MaxDirectMemorySize=1M -Xlog:gc
 * @author zhaoshengqi
 * @date 2020/6/19 4:26 下午
 */
public class DirectMemoryOOM_9 {
    private static final long _1MB = 1024 * 1024 * 30;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
            int a = 0;
        }
    }
}
