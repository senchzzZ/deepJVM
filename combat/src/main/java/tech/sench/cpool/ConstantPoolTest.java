package tech.sench.cpool;

/**
 * javap -verbose $FileClass$
 * Created by zhaoshengqi on 2018/6/6.
 */
public abstract class ConstantPoolTest {

    public String s;

    /*static {
        String s1 = "s111";
        s2 = "s222";
        //System.out.printf(s2);
    }*/
    static String s2 = "sss";

    public void test(long l1,long l2,String s1){
        System.out.println(s1 + s2);
    }

}
