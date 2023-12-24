package work2.mqyxrmwdxh.animalshop;

/**
 * @author 32867
 */
public class Tortoise extends AbstractAnimal {
    final int carapaceNum;

    Tortoise(String name, int age, double weight, SexEnum sex, double price, int carapaceNum) {
        super(name, age, price, weight, sex);
        this.carapaceNum = carapaceNum;
    }

    @Override
    public String toString() {
        return "乌龟" + name + "的体重是：" + weight + "kg,年龄是：" + age + "岁,背甲数目是：" + carapaceNum + "块,性别是：" + sex + ",价格为：" + price + "元。";
    }
}
