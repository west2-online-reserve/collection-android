public abstract class Animal {
    protected String name;
    protected int age;
    protected boolean isMale;
    protected double price;

    protected Animal(String name, int age, boolean isMale, double price) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        this.price = price;
    }

    public abstract String toString();
}
