package AnimalShop;

/**
 * @version 1.0 2023.10.31
 * @author feixiangdeyumao
 */
public class Dog extends Animal{
    protected boolean whetherVaccineInjected;
    public Dog(String animalName, int age, String gender, double price, double cost, boolean whetherVaccineInjected){
        this.animalName = animalName;
        this.age = age;
        this.gender = gender;
        this.price = price;
        this.cost = cost;
        this.whetherVaccineInjected = whetherVaccineInjected;
    }

    @Override
    public String toString(){
        return "This dog is called: " + animalName + ", it's gender is :" + gender + ", price is: " + price + ", vaccination status: " + whetherVaccineInjected;
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

    public boolean getIsVaccineInjected() {
        return whetherVaccineInjected;
    }

    public void setIsVaccineInjected(boolean isVaccineInjected) {
        this.whetherVaccineInjected = whetherVaccineInjected;
    }
}
