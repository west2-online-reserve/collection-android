package AnimalShop;

/**
 * @version 1.0 2023.10.31
 * @author feixiangdeyumao
 *
 * AnimalShop是一个抽象方法,定义了一个抽象类 toString
 */
abstract public class Animal {
    protected String animalName;
    protected int age;
    protected String gender;
    protected double price;
    protected double cost;

    public Animal(){
        animalName = "animal";
        age = 1;
        gender = "Male";
        price = 1;
        cost = 1;
    }

    public Animal(String animalName, int age, String gender, double price, double cost){
        this.animalName = animalName;
        this.age = age;
        this.gender = gender;
        this.price = price;
        this.cost = cost;
    }

    @Override
    public abstract String toString();

    public String getAnimalName(){
        return  animalName;
    }
}
