package work2.hexiaohei;

/**
 * @version 1.0 2023.10.13
 * @author hexiaohei
 */
public abstract class Animal {
    protected String name;
    protected int age;
    protected String sex;
    protected double price;
    protected double cost;
    protected boolean isVaccineInjected;

    public Animal(){

    }


    public Animal(String name, int age, String sex, double price, double cost, boolean isVaccineInjected) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.price = price;
        this.cost = cost;
        this.isVaccineInjected = isVaccineInjected;
    }


    public abstract String toString();
}
