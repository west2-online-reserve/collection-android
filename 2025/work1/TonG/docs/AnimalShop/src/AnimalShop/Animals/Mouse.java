package AnimalShop.Animals;

import AnimalShop.Animal;

    public class Mouse extends Animal {
        public Mouse(char sex, String name, int age) {
            super(sex, name, age, 1919810);
        }

        @Override
        public String toString() {
            return ("[一只小蜀黍：名字是:" + name
                    + " 性别是:" + sex
                    + " 年龄是:" + age
                    + " 价格是:" + cost
                    + "]"
            );
        }

    }

