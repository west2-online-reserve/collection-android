public class Rabbit extends Animal {
    public Rabbit(String name, int age, String gender) {
        super(name, age, gender, 150.0);
    }

    @Override
    public String toString() {
        return "兔子 [name=" + name + ", age=" + age + ", gender=" + gender + ", price=" + price + "]";
    }

}
