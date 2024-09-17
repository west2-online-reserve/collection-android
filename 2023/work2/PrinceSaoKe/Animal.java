package work2.PrinceSaoKe;

public abstract class Animal {
    protected String name;
    protected int age;
    protected double price;
    protected Sex sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Animal(String name, int age, double price, Sex sex) {
        this.name = name;
        this.age = age;
        this.price = price;
        this.sex = sex;
    }

    public abstract String toString();
}
