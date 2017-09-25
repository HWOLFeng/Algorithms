package Thread;

import java.util.concurrent.Callable;

public class CallableDemo {
    public static void main(String[] args) {
        Callable<Integer> task = ()->{
            return 123;
        };
    }
}
