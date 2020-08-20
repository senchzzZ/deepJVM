package tech.sench.classloader.hotswap;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zhaoshengqi on 2019/9/6.
 */
public class DoopRun {
    public static void main(String[] args) {
        while (true){
            try {
                MyClassLoader loader = new MyClassLoader("/Users/zhaoshengqi/Workspace/deepJVM/combat/target/classes/");
                Class cls = loader.loadClass("tech.sench.classloader.hotswap.DemoA");
                Object demoA = cls.getDeclaredConstructor().newInstance();
                Method m = demoA.getClass().getDeclaredMethod("hot",new Class[]{});
                m.invoke(demoA, new Object[]{});
                Thread.sleep(1000);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
