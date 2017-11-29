package collection;

import java.util.*;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/11/26.
 */
public class HashMapTest {
    public static void main(String[] args) {
        boolean flag;
        Map map;
        HashMap hashMap ;
        HashSet hashSet = new HashSet<>();
        hashSet.add(1);
        if (flag = hashSet.add(1) == true){
            System.out.println(true);
        }else {
            System.out.println(false);
        }

    }
}
