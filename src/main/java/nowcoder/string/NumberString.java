package nowcoder.string;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/a6a656249f404eb498d16b2f8eaa2c60?tpId=85&&tqId=29898&rp=1&ru=/activity/oj&qru=/ta/2017test/question-ranking
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/19.
 */
public class NumberString {
    private static void sort(List<Integer> numbers){
        // 排序，重写compare方法
        Collections.sort(numbers,(o1,o2)->{
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            return (s2 + s1).compareTo(s1 + s2);
        });
        // 输出
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            // 读取数据
            for (int i = 0; i < n; i++) {
                list.add(scanner.nextInt());
            }
            sort(list);
            System.out.println();
        }
    }
}
/*
2
12 123
4
7 13 4 246
 */