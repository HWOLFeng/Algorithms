package offer;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/21.
 */
public class SumSolution {
    public int sumSolution(int n) {

        return n*(n+1)/2;
    }

    public static void main(String[] args) {
        System.out.println(new SumSolution().sumSolution(5));
    }
}
