public class Monkey extends Animal {
    public Monkey(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public double getPrice() {
        return 100.0;
    }

    @Override
    public String toString() {
        return "Monkey{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
