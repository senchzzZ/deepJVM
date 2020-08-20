package tech.sench.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

/**
 * Created by zhaoshengqi on 2018/6/5.
 */
public class ClassLoaderTest extends LoaderExtends {


    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }

        };


        Class clazz = myLoader.loadClass("tech.sench.classloader.ClassLoaderTest");

        Object obj = clazz.getDeclaredConstructor().newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoaderTest);
    }
}