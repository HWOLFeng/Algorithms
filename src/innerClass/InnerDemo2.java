package innerClass;

public class InnerDemo2 {
    public static void main(String[] args) {
        new Outer2().function();
    }
}
class Outer2{
    int x = 3;
    void function(){
//        很帅，不用final了
        int y=4;
        class Inner{
            void show(){
                System.out.println(y);
            }
            void show2(int a){
                System.out.println(a);
            }
        }
        new Inner().show();
        new Inner().show2(3);
    }
}
