package nowcoder;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/1/19.
 */
public class MyFibonacci {
    /**
     * 比较容易理解
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    /**
     * 循环实现，性能好很多
     * @param n
     * @return
     */
    public int finbonacciLoop(int n){
        int[] result = {0,1};
        if (n<2){
            return result[n];
        }
        for (int i = 2; i <= n; i++) {
            int temp = result[0]+result[1];
            result[0] = result[1];
            result[1] = temp;
        }
        return result[1];
    }

    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        int sum = new MyFibonacci().fibonacci(39);
        long time2 = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println(time2-time1);
        System.out.println("================================");
        long time3 = System.currentTimeMillis();
        int sum1= new MyFibonacci().finbonacciLoop(39);
        long time4 = System.currentTimeMillis();
        System.out.println(sum1);
        System.out.println((time4-time3));
        System.out.println("================================");
        System.out.println(sum == sum1);
    }
}
