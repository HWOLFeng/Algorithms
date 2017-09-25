package java8;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.reducing;

public class Reducing {
    public static void main(String[] args) {
        List<Object> menu = Arrays.asList(
                new Dish("1","good","good",1),
                new Dish("1","good","bad",2),
                new Dish("1","bad","good",3),
                new Dish("1","bad","bad",4)
                );
    }
}
