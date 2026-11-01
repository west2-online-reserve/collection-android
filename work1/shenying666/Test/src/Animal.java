public abstract class Animal {
    private String name;
    private int age;
    private double price;
    private String gender;

    public Animal(String name, int age, double price, String gender) {
        this.name = name;
        this.age = age;
        this.price = price;
        this.gender = gender;
    }
    public abstract String toString();

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getGender() {
        return gender;
    }
}
