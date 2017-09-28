package singleton;

/*
懒汉加载模式

多线程下不能正常工作

 */
public class SimpleSingleton {
    private static SimpleSingleton instance;

    public SimpleSingleton() {
    }

    public void show(){
        System.out.println(this);
    }

    public static SimpleSingleton getInstance(){
        if (instance==null)
            instance = new SimpleSingleton();
        return instance;
    }
}
