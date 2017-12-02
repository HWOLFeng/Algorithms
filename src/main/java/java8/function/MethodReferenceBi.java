package java8.function;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/2.
 */
public class MethodReferenceBi {
    public static void formatPrint(BiFunction<String,List<String>,String> stringFormatter,String delimiter,List<String> list){
        String formattedList = stringFormatter.apply(delimiter,list);
        System.out.println(formattedList);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hwf","qdk","dzq","lh");
        // 因为String::join 是接受两个参数，并返回一个参数，所以可以用Bifunction 来替代自己实现的接口，速度也快了好多
        formatPrint(String::join,",",list);
    }

}
