package singleton;

/**
 * 利用内部类实现单例模式
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/11/29.
 */
public class InnerSingleton {

    public InnerSingleton(){

    }
    private static class Inner{
        private static InnerSingleton  innerSingleton= new InnerSingleton();
    }

    public static InnerSingleton getInnerSingleton(){
        return Inner.innerSingleton;
    }

}
