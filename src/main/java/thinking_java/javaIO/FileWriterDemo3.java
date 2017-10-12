package thinking_java.javaIO;

import java.io.FileWriter;
import java.io.IOException;

/*
不覆盖文件，追加文件
 */
public class FileWriterDemo3 {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
//            允许追加
            fileWriter = new FileWriter("demo2",true);
//            往程序外面写
            fileWriter.write("\nappend");

        }catch (IOException e){
            System.out.println("Exception 1"+e.toString());
        }finally {
            try {
                if (fileWriter!=null)
                    fileWriter.close();
            }catch (IOException e){
                System.out.println(e.toString());
            }
        }
    }
}
