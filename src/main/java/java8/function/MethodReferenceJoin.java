package java8.function;

import java.util.Arrays;
import java.util.List;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/2.
 */
public class MethodReferenceJoin {
    @FunctionalInterface
    interface StringFormatter{
        String format(String delimiter, List<String> list);
    }

    public static void formatList(StringFormatter stringFormater,String delimiter,List<String> list){
        String formatString = stringFormater.format(delimiter,list);
        System.out.println(formatString);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hwf","qdk","dzq","lh");
        //String::join 就是StringFormatter的具体实现
        formatList(String::join,",",list);
    }
}

