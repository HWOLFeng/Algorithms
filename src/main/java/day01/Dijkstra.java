package day01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author HWOLF
 * @version create in：17-10-19 下午1:33
 * @descrption
 */
public class Dijkstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Stack<Double> numbers = new Stack();
        Stack<String> operations = new Stack();
        String[] tempsNum = input.split("[^0-9]*");
        String[] tempsOp = input.split("[0-9]*[/(]*");
        for (String temp : tempsNum) {
            if (temp.equals(""))continue;
            numbers.add(Double.parseDouble(temp.replace(" ","")));
            System.out.print(Double.parseDouble(temp.replace(" ",""))+" ");
        }
//        for (String s : tempsOp) {
//            if (s.equals(""))continue;
//            System.out.print(s+" ");
//        }

    }
//    (123+123-(123*123)/123.0)
}
