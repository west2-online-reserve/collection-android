public abstract class Animal {
    protected String name;
    protected int age;
    protected boolean male;
    protected double price;

    protected Animal(String name, int age, boolean male, double price) {
        this.name = name;
        this.age = age;
        this.male = male;
        this.price = price;
    }

    public int getAge() {
        return this.age;
    }

    public boolean isMale() {
        return this.male;
    }

    public double getPrice() {
        return this.price;
    }

    public abstract String toString();

    public String getName() {
        return this.name;
    }
}
