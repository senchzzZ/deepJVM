package tech.sench.view;

/**
 * -Xmx10m
 * @author zhaoshengqi
 * @date 2020/6/19 3:56 下午
 */
public class JHSDB_TestCase {

    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            var a = 1;
            ObjectHolder localObj = new ObjectHolder();
            System.out.println(a); // 这里设一个断点
        }
    }

    private static class ObjectHolder {
    }

    public static void main(String[] args) {
        Test test = new JHSDB_TestCase.Test();
        test.foo();
    }
}
