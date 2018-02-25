package java8;


import java.util.*;
import java.util.function.Function;

interface MailBox{
    public String lean(int degree);
    public default void standUp(){
        System.out.println("我站起来了");
    }
    public static void sitDown(){
        System.out.println("我坐下了");
    }
}

class Tourist{

    public String name;
    public String city;

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Tourist() {
    }

    public Tourist(String name) {
        this.name = name;
    }

    public Tourist(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void push(MailBox mailBox){
        System.out.println("我是推的第一行");
        String message = mailBox.lean(70);
        System.out.println(message);
        //可以用实例使用
        mailBox.standUp();
    }
}

public class Sample {
    public static void main(String[] args) {
        //可以直接使用
        MailBox.sitDown();

        List<Tourist> tourists = new ArrayList<>();

        tourists.add(new Tourist("first"));
        tourists.add(new Tourist("second"));
        tourists.add(new Tourist("third"));
        tourists.add(new Tourist("fourth","tianjin"));
        tourists.add(new Tourist("fifth","fujian"));
        new Tourist().push((degree)->{
            System.out.println("我是游客");
            return "我弯了" + degree + "度";
        });

        System.out.println();
        System.out.println();
        listAllTourists(tourists,Tourist::getName);
        System.out.println();
        System.out.println();
        listAllTourists(tourists,Tourist::getCity);

        testFunction();
    }
    public static void listAllTourists(List<Tourist> list, Function<Tourist,String> function){
        System.out.println("大家都要派对");
        for (Tourist tourist : list){
            System.out.println(function.apply(tourist));
        }
    }
    public static void testFunction(){
        // 简单的,只有一行
        Function<Integer, String> function1 = (x) -> "1234|" + x;

        // 标准的,有花括号, return, 分号.
        Function<String, Integer> function2 = (x) -> {
            return x.length();
        };
        // 第三个处理方法
        Function<Integer,String>  function3 = (x)-> "the length is " + x;
        // 1.控制台输出：1234|6
        System.out.println(function1.apply(6));
        // 2.控制台输出：the length is 6
        System.out.println(function1
                .andThen(function2)
                .andThen(function3)
                .apply(6));

        // 适配接口，返回HashMap
        Function<Integer,HashMap<Integer,String>> function4 = (x)->{
            HashMap hashMap = new HashMap();
            hashMap.put(x,x+"号");
            return hashMap;
        };
        // 被适配接口，获取Map中的第一个值
        Function<Map<Integer,String>,String> function5 = (x)-> x.get(1);
        // 可接受Integer类型的参数
        // 控制台输出：1号
        System.out.println(function5.compose(function4).apply(1));
    }

}
