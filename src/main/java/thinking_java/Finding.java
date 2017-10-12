package thinking_java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finding {
    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("\\w+").matcher("Everything is full of the linnet's wings");
        while (matcher.find())
            System.out.print(matcher.group() + " ");
        int i = 0;
        while (matcher.find(i)){
            System.out.println(matcher.group()+" ");
            i++;
        }
    }
}
