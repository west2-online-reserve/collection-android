package AnimalShop;

abstract public class Animal {
    protected String name;
    protected  int age;
    protected  char sex;
    protected double cost;

    public Animal(char sex, String name, int age, double cost) {
        this.sex = sex;
        this.name = name;
        this.age = age;
        this.cost = cost;
    }

    public abstract String toString();
}

