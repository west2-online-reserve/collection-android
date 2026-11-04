package example.pet.animal;

public abstract class Animal {
    protected String name;
    protected int age;
    protected Gender gender;
    protected double price;

    public Animal(String name, int age, Gender gender, double price) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.price = price;
    }

    public abstract String toString();

    public enum Gender {
        MALE, FEMALE
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public Gender getGender(){
        return gender;
    }

    public double getPrice(){
        return price;
    }

}
