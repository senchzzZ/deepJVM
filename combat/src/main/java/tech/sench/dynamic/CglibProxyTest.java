package tech.sench.dynamic;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zhaoshengqi on 2018/8/21.
 */
public class CglibProxyTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SuperClass.class);
        enhancer.setUseCache(false);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before....");
                methodProxy.invokeSuper(o,args);
                System.out.println("after....");

                return null;
            }
        });

        SuperClass proxy = (SuperClass) enhancer.create();
        proxy.request();
    }

}

class SuperClass{
    public void request(){
        System.out.println("request...");
    }
}
