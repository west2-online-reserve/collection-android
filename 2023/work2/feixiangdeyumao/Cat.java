package AnimalShop;

/**
 * @version 1.0 2023.10.31
 * @author feixiangdeyumao
 */
public class Cat extends Animal{

    public Cat(String animalName, int age, String gender, double price, double cost){
        this.animalName = animalName;
        this.age = age;
        this.gender = gender;
        this.price = price;
        this.cost = cost;
    }

    @Override
    public String toString(){
        return "This cat is called: " + animalName + ", it's gender is :" + gender + ", price is: " + price;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
