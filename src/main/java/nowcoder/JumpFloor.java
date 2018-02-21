package nowcoder;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/1/19.
 */
public class JumpFloor {
    public int jumpFloor(int target) {
        if (target==1||target==0){
            return target;
        }
        if (target==2){
            return  2;
        }
        return jumpFloor(target-1)+jumpFloor(target-2);
    }
    public int jumpFloor1(int target) {
        int[] result = {1,2};
        if (target==1||target==0){
            return target;
        }
        if (target==2){
            return  2;
        }
        for (int i = 2; i < target; i++) {
            int temp = result[0] + result[1];
            result[0] = result[1];
            result[1] = temp;
        }
        return result[1];
    }
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            int sum = new JumpFloor().jumpFloor(i);
            int sum1 = new JumpFloor().jumpFloor1(i);
            System.out.println(sum==sum1);
        }


    }
}
