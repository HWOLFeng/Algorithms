package collection;

import java.util.LinkedList;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/11/26.
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        for (Integer i = 0; i < 10; i++) {
            list.add(i.toString());
        }
        list.stream().forEach(s -> System.out.println(s));
        System.out.println("===================");
        System.out.println(list.peek());
        System.out.println("====================");
        System.out.println(list.element());

    }
}
