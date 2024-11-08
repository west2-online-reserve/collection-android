public class Cat extends Animal {
    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public double getPrice() {
        return 200.0;
    }

   
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
