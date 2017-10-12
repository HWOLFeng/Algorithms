package thinking_java.javaIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyText {
    public static void main(String[] args) {

    }
//    读一个，写一个
    public static void copy1(){
        FileWriter fileWriter = null;
        FileReader fileReader = null;
        try {
//            目的地
            fileWriter = new FileWriter("dmeo2");
//            源文件
            fileReader = new FileReader("demo1");
            char[] ch = new char[1024];
            int num = 0;
            while ((num=fileReader.read(ch))!=-1){
//                保证长度
                fileWriter.write(ch,0,num);
            }
        } catch (IOException e) {
            throw new RuntimeException("读写失败");
        }finally {
            if (fileReader!=null)
                try {
                    fileReader.close();
                }catch (IOException e){

                }
            if (fileWriter!=null)
                try{
                    fileWriter.close();
                }catch (IOException e){

                }

        }
    }
}
