package work2.mqyxrmwdxh.animalshop;

/**
 * @author 32867
 */
public class Cat extends AbstractAnimal {
    private String variety;

    Cat(String name, int age, double weight, SexEnum sex, String variety) {
        super(name, age, 200, weight, sex);
        this.variety = variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getVariety() {
        return variety;
    }

    @Override
    public String toString() {
        return "小猫" + name + "的体重是：" + weight + ",年龄是：" + age + ",品种是：" + variety + ",性别是：" + sex + ",价格为：" + price + "。";
    }
}
