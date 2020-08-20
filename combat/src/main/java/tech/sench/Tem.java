package tech.sench;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhaoshengqi
 * @date 2020/7/14 11:27 上午
 */
public class Tem {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));

        Map<String,String> map = new TreeMap();
        map.put("1","abc");
        map.put("2","edf");
        map.put("r","aaa");
        map.put("a","acd");
        System.out.println(map);


    }


}
