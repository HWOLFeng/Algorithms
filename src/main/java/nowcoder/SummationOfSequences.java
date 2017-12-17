package nowcoder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/17.
 */
public class SummationOfSequences {

    /**
     * 平均数，个数
     * @param n
     * @param l
     * @return
     */
    private static ArrayList<Integer> result(int n, int l) {
        ArrayList<Integer> num = new ArrayList<>();
        if (n / l == 1){
            return num;
        }
        int sum = 0;
        // 计算平均数
        int averageNum = n / l;
        // 先加入平均数，判断平均数是否符合条件
        num.add(averageNum);
        sum += averageNum;
        if (sum == n && num.size()>=l){
            return num;
        }
        // 求和方法
        for (int i = 1; i < averageNum / 2; i++) {
            if (sum > n){
                break;
            }
            // 先加大的
            sum += averageNum + i;
            num.add(averageNum + i);
            if (sum == n && num.size() >= l){
                return num;
            }
            // 再加小的，不为负数
            if (averageNum - i < 0){
                break;
            }
            sum += averageNum - i;
            num.add(averageNum - i);
            if (sum == n && num.size() >= l){
                return num;
            }
        }
        // 递归
        return result(n, l+1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int L = scanner.nextInt();
        ArrayList<Integer> num = result(N,L);
        if (num.size() == 0){
            System.out.println("No");
        }
        StringBuilder stringBuilder = new StringBuilder();
        num.sort(Comparator.comparingInt(o -> o));
        int sum = 0;
        for (Integer integer : num) {
            stringBuilder.append(integer).append(" ");
            sum += integer;
        }
        System.out.println(sum);
        System.out.println("===================");
        System.out.println(stringBuilder.substring(0,stringBuilder.length() - 1));

    }

}
