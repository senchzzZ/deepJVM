package sench;

/**
 * 开放defineClass方法
 * Created by zhaoshengqi on 2018/4/10.
 */
public class HotSwapClassLoader extends ClassLoader{
    public HotSwapClassLoader(){
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] classByte){
        return defineClass(null,classByte,0,classByte.length);
    }

}
