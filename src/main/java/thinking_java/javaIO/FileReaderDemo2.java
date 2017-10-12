package thinking_java.javaIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo2 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("demo2");

        char[] ch = new char[3];
//      可以根据数组长度，来将对应数量的字符装入数组，如下：装入三个字符
        int num = fileReader.read(ch);

        System.out.println(num+"内容是："+new String(ch));

//
    }
}
