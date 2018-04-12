package sench;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Created by zhaoshengqi on 2018/4/10.
 */
public class HackSystem {
    public static final InputStream in= System.in;

    private static ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    public static final PrintStream out = new PrintStream(buffer);
    public static final PrintStream err = out;

    public static String getBufferString(){
        return buffer.toString();
    }

    public static void setSercurityManager(final SecurityManager s){
        System.setSecurityManager(s);
    }

    public static SecurityManager getSercurityManager(){
        return System.getSecurityManager();
    }

    public static void arrayCopy(Object src,int srcPos,Object dest,int destPos,int length){
        System.arraycopy(src,srcPos,dest,destPos,length);
    }

    public static int identityHashCode(Object x){
        return System.identityHashCode(x);
    }


    public static void clearBuffer() {
        buffer.reset();
    }
}
