package thinking_java.javaIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo2 {
    public static void main(String[] args) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("demo2");

            fileWriter.write("demo2");

//            fileWriter.flush();

        }catch (IOException e){
            System.out.print(e.toString());
        }finally {
//            最终都会运行
          try {
              if (fileWriter!=null)
              fileWriter.close();
          } catch (IOException e){
              System.out.println(e.toString());
          }
        }

    }
}
