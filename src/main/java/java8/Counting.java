package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Counting {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
        new Dish("1","good","good"),
        new Dish("2","good","bad"),
        new Dish("3","bad","bad")

        );
//        long howManyDishes = menu.stream().collect(Collectors.counting());
        long howManyDishes = menu.stream().count();
        System.out.println(howManyDishes);

        String shortMenu = menu.stream().map(Dish::getApple).collect(joining());
//        不可以 String shortMenu2 = menu.stream().collect(joining());
        String shortMenu2 = menu.stream().map(Dish::getBanana).collect(joining("; "));
        System.out.println(shortMenu);//goodgoodbad
        System.out.println(shortMenu2);//good; bad; bad
    }
}
