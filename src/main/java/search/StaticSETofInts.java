package search;

import java.util.Arrays;

/**
 * @author HWOLF
 * @version create in：17-10-18 下午9:44
 * @descrption
 */
public class StaticSETofInts {
    private int[] a;
    public StaticSETofInts(int[] keys){
        if (keys.length!=0)
            a = new int[keys.length];
            for (int i = 0; i < keys.length; i++) {
                a[i] = keys[i];
            }
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
    public boolean contain(int key){
        return rank(key) != -1;
    }
    public int rank(int key){
        int left = 0;
        int right = a.length-1;
        int mid;
        while (left<=right){
            mid = (left + right) / 2;
            if (key < a[mid]) right = mid - 1;
            else if (key > a[mid]) left = mid + 1;
            else return mid;
        }
        return -1;
    }
}
