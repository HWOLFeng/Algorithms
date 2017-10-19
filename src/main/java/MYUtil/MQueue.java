package MYUtil;

/**
 * @author HWOLF
 * @version create in：17-10-19 上午10:34
 * @descrption
 */
public interface MQueue<T> {
    /**
     * 添加一个元素
     * @param item
     */
    void enqueue(T item);

    /**
     * 删除最近添加的元素
     * @return
     */
    T dequeue();
    boolean isEmpty();
    int size();
}
