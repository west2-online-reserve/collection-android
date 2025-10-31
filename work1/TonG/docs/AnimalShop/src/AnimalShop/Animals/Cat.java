package AnimalShop.Animals;

import AnimalShop.Animal;

public class Cat extends Animal {
    public Cat(char sex, String name, int age) {
        super(sex, name, age, 100);
    }

    @Override
    public String toString() {
        return ("[一只小猫猫：名字是:"+name
        +" 性别是:"+sex
        +" 年龄是:"+age
        +" 价格是:"+cost
        +"]"
        );
    }
}
