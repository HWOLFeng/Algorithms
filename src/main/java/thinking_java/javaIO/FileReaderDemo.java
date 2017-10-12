package thinking_java.javaIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
//        读取文件保证存在
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("demo2");

//            循环读取
//            while (true){
//            read会自动往后读
//                int ch = fileReader.read();
//                if (ch!=-1) 表示在文件末尾
//                    System.out.println(ch);
//            }
//            第二种方式，每次读取一定量的用于缓存的数组
            char[] ch = new char[1024];
            int num = 0;

            while ((num=fileReader.read(ch))!=-1){
//              不加回车
                System.out.print(new String(ch,0,num));
            }
        } catch (FileNotFoundException e){
            System.out.println(e.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader!=null)
                    fileReader.close();
            }catch (IOException e){
                System.out.println(e.toString());
            }
        }
    }
}
