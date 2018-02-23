package sort;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/1/11.
 */
public class SelectionData {

    private int[] nums;

    /**
     * 初始化数据
     * @param N           个数
     * @param randomBound 最大值
     */
    public SelectionData(int N, int randomBound) {
        nums = new int[N];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * randomBound) + 1;
        }
    }

    /**
     * 获取长度
     *
     * @return
     */
    public int getLength() {
        return nums.length;
    }

    /**
     * 获取元素
     * @param index 位置
     * @return
     */
    public int get(int index) {
        if (index >= getLength() || index < 0) {
            throw new IllegalArgumentException("越界啦");
        }
        return nums[index];
    }

    /**
     * 交换
     * @param left
     * @param right
     */
    public void swap(int left,int right){
        int temp = get(left);
        nums[left] = get(right);
        nums[right] = temp;
    }
}
