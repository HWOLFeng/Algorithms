package nowcoder;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/276712b113c6456c8cf31c5073a4f9d7
 *
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/18.
 */
public class KMP {
    private static int maxLength(String first, String second) {
        int count = 0;
        int firstLength = first.length();
        int secondLength = second.length();
        for (int i = 0; i < firstLength; i++) {
            for (int j = 0; j < secondLength; j++) {
                if (i+j >= firstLength){
                    break;
                }
                if (first.charAt(i+j) == second.charAt(j)){

                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        scanner.close();
        System.out.println(maxLength(first,second));
    }
}
