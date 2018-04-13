package tech.sench.view;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 -XX:+UseG1GC
 -XX:MetaspaceSize=1M
 -XX:MaxMetaspaceSize=10M
 -XX:+PrintGCDetails
 * Created by zhaoshengqi on 2018/4/13.
 */
public class CglibOOM {
    public static void main(String[] args) {
        for (;;){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMClass.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o,args);
                }
            });

            enhancer.create();
        }

    }
    static class OOMClass{}
}
