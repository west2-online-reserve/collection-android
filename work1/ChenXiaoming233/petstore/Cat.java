package petstore;

// 猫，固定售价 200 元

public class Cat extends Animal {
    public Cat(String name, int age, String gender) {
        super(name, age, gender, 200);
    }

    @Override
    public String toString() {
        return "猫{name='" + name + "', age=" + age
                + ", gender='" + gender + "', price=" + price + "}";
    }
}
