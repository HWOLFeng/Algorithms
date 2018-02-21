package nowcoder;


import java.util.function.Function;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/1/4.
 */
public class ReplaceSpace {
    /**
     * 这题对java太简单了
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll("\\s", "%20");
    }

    public static void main(String[] args) {
        // 计算圆面积
        Function<Integer,Double> calCircleArea = (r)-> 3.14159 * r;
        int r = 2;

        double circleArea = calCircleArea.apply(r);
//        int circleArea1 = calCircleArea.apply(r);
    }

}
