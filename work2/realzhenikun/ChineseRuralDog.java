/**
 * @Author：realzhenikun
 * @Project：PetShop
 * @Date：2023/11/6
 * @Filename：ChineseRuralDog
 */
public class ChineseRuralDog extends AbstractAnimal {
    private boolean isVaccineInjected;
    public ChineseRuralDog(String animalName, int age, String sex, boolean isVaccineInjected) {
        super(animalName, age, sex, 100);
        this.isVaccineInjected = isVaccineInjected;
    }

    public void setIsVaccineInjected(boolean isVaccineInjected) {
        this.isVaccineInjected = isVaccineInjected;
    }

    public boolean getIsVaccineInjected() {
        return isVaccineInjected;
    }

    @Override
    public String toString() {
        return "中华田园犬\n" + "名字:" +animalName + "\n年龄:" + age + "\n性别:" + sex + "\n价格:" + price + "\n是否注射狂犬疫苗:" + isVaccineInjected+ '\n';
    }
}
