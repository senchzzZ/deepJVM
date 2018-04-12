package sench.remote;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zhaoshengqi on 2018/4/10.
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("D:\\Workspace\\deepJVM\\remote-executor\\target\\classes\\sench\\TestClass.class");
        byte[] b = new byte[is.available()];
        is.read(b);
        is.close();
        System.out.println(JavaClassExecuter.execute(b));
    }
}
