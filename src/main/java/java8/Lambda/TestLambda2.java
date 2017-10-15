package java8.Lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class TestLambda2 {
    //    1.无参数，无返回值
    @Test
    public void test1() {
        Runnable runnable = () -> System.out.println("Hello World");
    }

    //    2.有参数，无返回值
    @Test
    public void test2() {
//        Lambda 表达式将accept中的参数传递过去给x
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("Hello Consumer");
    }
//    3.有参数，有返回值

    //    4.有参数，并且Lambda中有多条语句，这时候需要return
    @Test
    public void test4() {
        Comparator<Integer> comparator = (x,y) -> {
            System.out.println("test4");
            return Integer.compare(x,y);
        };
    }

    //    5.有参数，只有一条语句
    @Test
    public void test5() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
    }
}
