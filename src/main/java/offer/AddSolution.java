package offer;


/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/29.
 */
public class AddSolution {
    public int Add(int num1, int num2) {
        while (num2!=0){
            // 求和
            int temp = num1^num2;
            // 进位值
            num2=(num1&num2)<<1;
            num1=temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(new AddSolution().Add(3,2));
    }
}
