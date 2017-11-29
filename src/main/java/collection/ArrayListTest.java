package collection;

import java.util.ArrayList;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/11/25.
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("No 1");
        arrayList.add("No 2");
        arrayList.add(2,"No 3");
        System.out.println(arrayList.size());
//        不能越界添加元素
//        arrayList.add(6,"No 6");
        /**
         * 第一次输出 arrayList 中的元素
         */
        for (String s : arrayList) {
            System.out.println(s);
        }

        ArrayList<String> arrayList1 = new ArrayList<>();

        //比较地址
        System.out.println(arrayList);
        System.out.println(arrayList1);

        for (int i = 7; i < 9; i++) {
            arrayList1.add("No "+ i);
        }
        arrayList.addAll(arrayList1);

        /**
         * 第二次测试输出 arrayList 中的元素
         */
        System.out.println(arrayList.size());
        for (String s : arrayList) {
            System.out.println(s);
        }

        System.out.println("----------");
        /**
         * arrayList1 clone arrayList
         */
        arrayList1 = (ArrayList<String>) arrayList.clone();
        for (String s : arrayList1) {
            System.out.println(s);
        }

        /**
         * 清楚后输出 arrayList 的大小
         */
        arrayList.clear();
        System.out.println(arrayList.size());

    }
}
