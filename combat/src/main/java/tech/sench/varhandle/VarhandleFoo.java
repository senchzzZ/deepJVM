package tech.sench.varhandle;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * Created by zhaoshengqi on 2018/4/2.
 */
public class VarhandleFoo {

    private Point[] points;

    private static final VarHandle QA;//for arrays
    private static final VarHandle X;//for arrays
    static {
        QA =  MethodHandles.arrayElementVarHandle(Point[].class);
        try {
            X = MethodHandles.lookup().
                    findVarHandle(Point.class, "x", int.class);
        } catch (ReflectiveOperationException e) {
            throw new Error(e);
        }
    }
    // ...

    static class Point {
        volatile int x, y;
        // ...
    }

    public static void main(String[] args) {
        Point p = new Point();
        X.compareAndSet(p,0,10);
        System.out.println(p.x);

    }

}
