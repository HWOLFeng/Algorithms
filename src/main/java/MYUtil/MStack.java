package MYUtil;

/**
 * @author HWOLF
 * @version create in：17-10-19 上午10:34
 * @descrption
 */
public interface MStack<T> {
    /**
     * 添加一个元素
     * @param item
     */
    void push(T item);

    /**
     * 删除最近的元素
     * @return
     */
    T pop();
    boolean isEmpty();
    int size();
}
