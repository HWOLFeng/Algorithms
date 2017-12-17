package nowcoder;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/e95337f886f54110b92318f693cd8fad
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/17.
 */
public class DNASynthesis {

    public static boolean checkType(char left,char right){
        char temp;
        // 小的字符为 left
        if (left - right > 0){
            temp = left;
            left = right;
            right = temp;
        }
        // 判断类型是否相同
        if (left=='A' && right=='T'){
            return true;
        }else if (left=='C' && right=='G') {
            return true;
        } else {
            return false;
        }
    }

    public static int count(String first,String second){
        int count = 0;
        String combineString = first + second;
        int length = first.length();
        for (int i = 0; i < length; i++) {
            // 调用 checkType，如果不同，count++
            if (!checkType(combineString.charAt(i),combineString.charAt(length + i))){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.next();
        String second = scanner.next();
        System.out.println(count(first,second));
    }
}
