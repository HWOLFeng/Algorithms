package innerClass;

class Outer {
    private int x = 3;
    class Inner {
        void function(){
//            可以直接访问外部类的私有成员
            System.out.println("inner : " + x);
//            等价于：
            System.out.println("inner2: "+ Outer.this.x);
        }
    }
    void method() {
        System.out.println(x);
        //外部类想要访问内部类，必须建立内部类对象。
        Inner inner = new Inner();
        inner.function();
    }

}
public class InnerClassDemo {
    public static void main(String[] args) {
        Outer out = new Outer();
        out.method();
    }
}
