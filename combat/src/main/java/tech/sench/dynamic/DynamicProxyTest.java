package tech.sench.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhaoshengqi on 2018/6/7.
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        //Iface iface = (Iface) new DynamicHandler().bind(new IfaceImpl());
        Iface i = new IfaceImpl();
        DynamicHandler dynamicHandler = new DynamicHandler(i);
        Iface iface = (Iface) Proxy.newProxyInstance(i.getClass().getClassLoader(),i.getClass().getInterfaces(),dynamicHandler);

        iface.hi("ssss");
    }

    interface Iface{
        void hi(String s);
    }

    static class IfaceImpl implements Iface{
        @Override
        public void hi(String s) {
            System.out.println(s);
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
