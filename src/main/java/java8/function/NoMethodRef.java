package java8.function;


import java.util.Arrays;
import java.util.List;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/2.
 */
public class NoMethodRef {
    @FunctionalInterface
    interface StringFormatter{
        String format(String delimiter, List<String> list);
    }

    public static void formatPrinter(StringFormatter stringFormatter,String delimiter,List<String> list){
        String formatList = stringFormatter.format(delimiter,list);
        System.out.println(formatList);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hwf","qdk","dzq","lh");
        // 实现接口
        StringFormatter stringFormatter = (delimiter, list1) -> {
          StringBuilder stringBuilder = new StringBuilder(100);
          int size = list.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append(list.get(i));
                if (i < size-1){
                    stringBuilder.append(delimiter);
                }
            }
            return stringBuilder.toString();
        };
        formatPrinter(stringFormatter,",",list);
        String format = stringFormatter.format(",",list);
        System.out.println(format);
    }
}
