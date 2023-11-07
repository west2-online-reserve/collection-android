package GoldenCreeperJ;

/**
 * @author GoldenCreeperJ
 * @date 2023/11/7
 */
public abstract class Animal {
    protected String name;
    protected int age;
    protected String gender;
    protected double price;

    public Animal(String name, int age, String gender, double price) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.price = price;
    }

    public Animal() {

    }

    public double getPrice() {
        return price;
    }

    @Override
    public abstract String toString();
}
