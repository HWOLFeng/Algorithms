package thinking_java.javaIO;

import java.io.FileWriter;
import java.io.IOException;

/*
主要是操作文件。

找Writer对应的子类对象。派生子类都是按照父类的名作为后缀，前缀是功能。

java会根据操作系统的不同调用系统及级别底层的方法，实现最终的读写文件的效果。
 */
public class WriterDemo {
    public static void main(String[] args) throws IOException {
//        创建一个FileWriter对象。该对象一被初始化就必须要明确文件路径。
        FileWriter fileWriter =  new FileWriter("demo.txt");
//        写入字符串
        fileWriter.write("abcde");
//        将缓冲区的数据提交上去
        fileWriter.flush();
//        刷新并关闭缓冲流，之后就不能flush了
        fileWriter.write("\nabcd");
        fileWriter.close();
    }
}
