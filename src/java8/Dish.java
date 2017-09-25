package java8;

public class Dish {
    public String dishes;
    public String apple;
    public String banana;
    public int price;

    public String getDishes() {
        return dishes;
    }

    public void setDishes(String dishes) {
        this.dishes = dishes;
    }

    public String getApple() {
        return apple;
    }

    public void setApple(String apple) {
        this.apple = apple;
    }

    public String getBanana() {
        return banana;
    }

    public void setBanana(String banana) {
        this.banana = banana;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Dish(String dishes, String apple, String banana) {
        this.dishes = dishes;
        this.apple = apple;
        this.banana = banana;
    }

    public Dish(String dishes, String apple, String banana, int price) {
        this.dishes = dishes;
        this.apple = apple;
        this.banana = banana;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "banana='" + banana + '\'' +
                '}';
    }
}
