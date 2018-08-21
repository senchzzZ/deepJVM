package tech.sench.dynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * dynamic support test
 * MethodHandle使用
 * the light Reflection
 * Created by zhaoshengqi on 2018/6/7.
 */
public class MethodHandleTest {
    static Object x;
    static String s;
    static int i;
    static MethodType mt;
    static MethodHandle mh;
    static MethodHandles.Lookup lookup = MethodHandles.lookup();

    public static void main(String[] args) throws Throwable {

        //the first is return type,the followers are parameters
        mt = MethodType.methodType(void.class,String.class);
        mh = lookup.findVirtual(ClassA.class,"println",mt);
        mh.invokeExact(new ClassA(),"you know what i mean");

        // mt is (char,char)String
        mt = MethodType.methodType(String.class, char.class, char.class);
        mh = lookup.findVirtual(String.class, "replace", mt);
        s = (String) mh.invokeExact("daddy", 'd', 'n');
        System.out.println(s);

        // invokeExact(Ljava/lang/String;CC)Ljava/lang/String;
        //assertEquals(s, "nanny");
        // weakly typed invocation (using MHs.invoke)
        s = (String) mh.invokeWithArguments("sappy", 'p', 'v');
        System.out.println(s);

        //assertEquals(s, "savvy");
        // mt is (Object[])List
        mt = MethodType.methodType(java.util.List.class, Object[].class);
        mh = lookup.findStatic(java.util.Arrays.class, "asList", mt);
        assert (mh.isVarargsCollector());
        x = mh.invoke("one", "two");
        System.out.println(x);

        // invoke(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
        //assertEquals(x, java.util.Arrays.asList("one","two"));
        // mt is (Object,Object,Object)Object
        mt = MethodType.genericMethodType(3);
        mh = mh.asType(mt);
        x = mh.invokeExact((Object) 1, (Object) 2, (Object) 3);
        System.out.println(x);

        // invokeExact(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //assertEquals(x, java.util.Arrays.asList(1,2,3));
        // mt is ()int
        mt = MethodType.methodType(int.class);
        mh = lookup.findVirtual(java.util.List.class, "size", mt);
        i = (int) mh.invokeExact(java.util.Arrays.asList(1, 2, 3));
        System.out.println(i);
        // invokeExact(Ljava/util/List;)I
        assert (i == 3);
        mt = MethodType.methodType(void.class, String.class);
        mh = lookup.findVirtual(java.io.PrintStream.class, "println", mt);
        mh.invokeExact(System.out, "Hello, world.");
        // invokeExact(Ljava/io/PrintStream;Ljava/lang/String;)V

    }

    static class ClassA {
        public void println(String s) {
            System.out.println(s);
        }
    }
}
