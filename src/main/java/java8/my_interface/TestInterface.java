package java8.my_interface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author: HWOLF
 * @version: create in：17-10-15 下午1:09
 * @descrption:
 */

/*
 * 四大函数式接口
 * Consumer--消费型，消费之后会有什么样的结果
 * Supplier--供给型，产生指定个数元素
 * Function--函数型
 * Predicate--断言型
 */
public class TestInterface {

    public void myConsumer(int m, Consumer<Integer> consumer) {
        consumer.accept(m);
    }

    @Test
    public void test1() {
        int m = 1000;
        myConsumer(m, (x) -> System.out.println("我消费了 " + x + "元"));
    }

    public List<Integer> getListSupplier(int n, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Integer m = supplier.get();
            list.add(m);
        }

        return list;
    }

    @Test
    public void test2() {
//        注意supplier.get回的是Integer
        List<Integer> list = getListSupplier(10, () -> (int) (Math.random() * 1000));

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    //      处理字符串
    public String testFunction(String s, Function<String, String> function) {
//      Function<Target,Source>
//      s是Source
//      return是Target
        return function.apply(s);
    }

    @Test
    public void test3() {
        String string = testFunction("我是你", (s) -> s.substring(1, 2));
        System.out.println(string);
    }

    //  提取满足需求的字符串
    public List<String> testPredicate(List<String> values, Predicate<String> predicate) {
        List<String> lists = new ArrayList<>();

        for (String value : values) {
            if (predicate.test(value))
                lists.add(value);
        }
        return lists;
    }

    @Test
    public void test4() {
        List<String> list = Arrays.asList("ab", "abc", "abcd", "abcde", "abcdef");

        List<String> list1 = testPredicate(list, (s) -> s.length() > 3);

        for (String s : list1) {
            System.out.println(s);
        }

    }
}
