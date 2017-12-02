package singleton;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/11/29.
 */
public class DLSingleton {
    private static DLSingleton doubleLockSingleton;

    private DLSingleton(){}

    public static DLSingleton getDLSingleton(){
        if (doubleLockSingleton == null){
            synchronized (DLSingleton.class){
                if (doubleLockSingleton == null){
                    synchronized (doubleLockSingleton){
                        doubleLockSingleton = new DLSingleton();
                    }
                }
            }
        }
        return doubleLockSingleton;
    }
}
