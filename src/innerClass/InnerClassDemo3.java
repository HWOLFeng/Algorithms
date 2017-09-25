package innerClass;

abstract class AbsDemo{
    abstract void show();
}

class Outer3{
    int x = 3;
    class Inner extends AbsDemo{

        @Override
        void show() {
            System.out.println("method" + x);
        }
    }
    public void function(){
        new Inner().show();
    }
    public void function2(){
        new AbsDemo(){
            void show(){
                System.out.println("absdemo:"+x);
            }
        };
    }
}

public class InnerClassDemo3 {
    public static void main(String[] args) {

    }
}
