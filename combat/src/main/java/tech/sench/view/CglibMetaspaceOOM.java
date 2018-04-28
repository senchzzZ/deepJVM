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
public class CglibMetaspaceOOM {
    public static void main(String[] args) {
        int i = 0;
        try {
            for (;;){
                i++;
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

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("第"+i+"次生成出现 metaspace 溢出问题");
        }
    }
    static class OOMClass{}
}
