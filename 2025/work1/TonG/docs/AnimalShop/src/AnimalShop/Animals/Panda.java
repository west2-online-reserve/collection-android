package AnimalShop.Animals;

import AnimalShop.Animal;

public class Panda extends Animal {
    public Panda(char sex, String name, int age) {
        super(sex, name, age, 1919810);
    }

    @Override
    public String toString() {
        return ("[一只大猫猫：名字是:"+name
                +" 性别是:"+sex
                +" 年龄是:"+age
                +" 价格是:"+cost
                +"]"
        );
    }
}
