package nowcoder;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/e3dd485dd23a42899228305658457927
 *
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/15.
 */
public class ManyFish {
    public static Set calType(int min, int max, int n, int[] fishSize) {
        Set<Integer> sizeLink = new HashSet<>();
        for (int i = min; i <= max; i++) {
            for (int j = 0; j < fishSize.length; j++) {
                if (i / fishSize[j] <= 1 || i / fishSize[j] > 10) {
                    sizeLink.add(i);
                }
            }
        }
        return sizeLink;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minSize = scanner.nextInt();
        int maxSize = scanner.nextInt();
        int n = scanner.nextInt();
        int[] fishSize = new int[n];
        for (int i = 0; i < n; i++) {
            fishSize[i] = scanner.nextInt();
        }
        Set<Integer> linkedList = calType(minSize,maxSize,n,fishSize);
//        StringBuilder s = new StringBuilder();
//        for (Integer integer : linkedList) {
//            s.append(integer).append(" ");
//        }
//        System.out.println(s.toString());
        System.out.println(linkedList.size());
    }
}
