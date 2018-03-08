package nowcoder;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/3/8.
 */
public class CalculateDate {
    private HashMap<Integer, Integer> monthDay = new HashMap<>();

    public void init1() {
        monthDay.put(1, 31);
        monthDay.put(2, 28);
        monthDay.put(3, 31);
        monthDay.put(4, 30);
        monthDay.put(5, 31);
        monthDay.put(6, 30);
        monthDay.put(7, 31);
        monthDay.put(8, 31);
        monthDay.put(9, 30);
        monthDay.put(10, 31);
        monthDay.put(11, 30);
        monthDay.put(12, 31);
    }

    public void init2() {
        init1();
        monthDay.put(2, 29);
    }

    public int calculate(int years, int month, int day) {
        int[] months = {};
        if (years > 3000 || years < 1 || month > 12 || month < 1 || day > 31 || day < 1) {
            throw new IllegalArgumentException("请输入正确参数");
        }
        int days = 0;
        if (isRunYear(years)) {
            init2();
            return sumDays(month, day);
        } else {
            init1();
            return sumDays(month, day);
        }
    }

    public int sumDays(int month, int day) {
        int sum = 0;
        if (monthDay.get(month) < day) {
            throw new IllegalArgumentException("请输入正确参数");
        }
        for (int i = 1; i < month; i++) {
            sum += monthDay.get(i);
        }
        sum += day;
        return sum;
    }

    public boolean isRunYear(int years) {
        boolean isRun = (years % 4 == 0 && years % 100 != 0) || years % 400 == 0;
        return isRun;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int years = scanner.nextInt();
            int mouth = scanner.nextInt();
            int day = scanner.nextInt();
            System.out.println(new CalculateDate().calculate(years, mouth, day));
        }
    }
}
