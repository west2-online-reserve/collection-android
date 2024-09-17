/**
 * @Author：realzhenikun
 * @Project：PetShop
 * @Date：2023/11/6
 * @Filename：Cat
 */
public class Cat extends AbstractAnimal {
    public Cat(String animalName, int age, String sex) {
        super(animalName, age, sex, 200);
    }

    @Override
    public String toString() {
        return "猫猫\n" + "名字:" +animalName + "\n年龄:" + age + "\n性别:" + sex + "\n价格:" + price + '\n';
    }
}
