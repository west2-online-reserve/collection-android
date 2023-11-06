package work2.mqyxrmwdxh.animalshop;

/**
 * @author 32867
 */
public class ChineseRuralDog extends AbstractAnimal {
    protected boolean isVaccineInjected;

    ChineseRuralDog(boolean isVaccineInjected, String name, int age, double weight, SexEnum sex) {
        super(name, age, 200, weight, sex);
        this.isVaccineInjected = isVaccineInjected;
    }

    public void setVaccineInjected(boolean vaccineInjected) {
        isVaccineInjected = vaccineInjected;
    }

    public boolean isVaccineInjected() {
        return isVaccineInjected;
    }

    @Override
    public String toString() {
        return "中华田园犬" + name + "的体重是：" + weight + ",年龄是：" + age + ",是否绝育：" + isVaccineInjected + ",性别是：" + sex + ",价格为：" + price + "。";
    }
}
