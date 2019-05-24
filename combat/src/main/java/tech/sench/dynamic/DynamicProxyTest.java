package tech.sench.dynamic;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhaoshengqi on 2018/6/7.
 */
public class DynamicProxyTest {

    public static void main(String[] args) throws IOException {
        //Iface iface = (Iface) new DynamicHandler().bind(new IfaceImpl());
        Iface i = new IfaceImpl();
        DynamicHandler dynamicHandler = new DynamicHandler(i);
        Object o = Proxy.newProxyInstance(i.getClass().getClassLoader(),i.getClass().getInterfaces(),dynamicHandler);
        Class<?>[] c = o.getClass().getInterfaces();
        System.out.println(c);
        Iface2 iface = (Iface2)o;

        iface.hi2("ssss");

        //生成代理类文件
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy", new Class[]{Iface.class});
        FileOutputStream out = new FileOutputStream(new File("/Users/zhaoshengqi/Workspace/eg-the-way/$Proxy0.class"));
        out.write(bytes);
        out.flush();
        out.close();
    }

    interface Iface{
        void hi(String s);
    }
    interface Iface2{
        void hi2(String s);
    }

    static class IfaceImpl implements Iface,Iface2{
        @Override
        public void hi(String s) {
            System.out.println(s);
        }

        @Override
        public void hi2(String s) {
            System.out.println("hi2 " + s);
        }
    }
    /*static class IfaceImpl2 implements Iface{
        @Override
        public void hi() {
            System.out.println("lue lue lue");
        }
    }*/

    static class DynamicHandler implements InvocationHandler{
        Object o;
        public DynamicHandler(Object o) {
            this.o = o;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before");
            method.invoke(o,args);
            System.out.println("after");
            return null;
        }
    }
}
