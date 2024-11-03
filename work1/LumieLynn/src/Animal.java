public abstract class Animal {
    protected String name;
    protected int age;
    protected boolean isMale;
    public Animal(String name, int age, boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }
    public abstract double getPrice();
    @Override
    public abstract String toString();
}
