package AnimalShop.Animals;

import AnimalShop.Animal;

public class Dog extends Animal {
    boolean isVaccineInjected;

    public Dog(char sex, String name, int age,boolean isVaccineInjected) {
        super(sex, name, age, 200);
        this.isVaccineInjected = isVaccineInjected;
    }

}
