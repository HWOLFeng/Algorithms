package MYUtil;

/**
 * @author HWOLF
 * @version create in：17-10-16 下午7:56
 * @descrption
 */
public class StackOfStrings {
    private int N;
    private String[] a;

    public StackOfStrings() {
    }

    public StackOfStrings(int n){
        this.a = new String[n];
    }
    public void push(String item){
        a[N++] = item;
    }
    public int size(){
        return N;
    }
    public String pop(){
        return a[--N];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public boolean isFull(){
        return N == size();
    }

}
