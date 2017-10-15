package MyTree;

import org.junit.Test;

/**
 * @author HWOLF
 * @version create in：17-10-15 下午7:02
 * @descrption
 */
public class UF {
    private int[] array;
    private int[] size;

    public UF(int n) {
        array = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
            size[i] = 1;
        }

    }

    public UF() {

    }

    public int root(int i) {
        if (i != array[i]) i = array[i];
        return i;
    }

    public void union(int p, int q) {
//        v.1
//        if (!connect(p,q)) array[p] = q;
//        System.out.println(array[p]);
//        v.2
//        int i = root(p);
//        int j = root(q);
//        if (!connected(p,q))array[i] = j;
        int i = root(p);
        int j = root(q);
        if (size[i] > size[j] && !connected(p, q)) {
            size[i] = size[i] + size[j];
            array[j] = i;
        }else {
            size[j] = size[i] + size[j];
            array[i] = j;
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public int[] getArray() {
        return array;
    }
}
