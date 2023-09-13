package work2.PrinceSaoKe;

public class ChinesePastoralDog extends Animal {
    boolean isVaccineInjected;

    public ChinesePastoralDog(String name, int age, Sex sex, boolean isVaccineInjected) {
        super(name, age, 100, sex);
        this.isVaccineInjected = isVaccineInjected;
    }

    @Override
    public String toString() {
        return "中华田园犬，名字：" + name + "，年龄：" + age + "岁，性别：" + sex + "，价格：" + price + "元，是否注射狂犬疫苗：" + isVaccineInjected;
    }
}
