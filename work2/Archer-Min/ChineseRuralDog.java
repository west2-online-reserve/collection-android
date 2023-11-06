public class ChineseRuralDog extends Animal{
    boolean isVaccineInjected;
    public ChineseRuralDog(String name, int age, String sex, boolean isVaccineInjected) {
        super(name, age, sex, 100,150);
        this.isVaccineInjected=isVaccineInjected;
    }

    @Override
    public String toString() {
        String s;
        if (isVaccineInjected){s="是";}else {s="否";};
        return "名字："+name+"\n年龄："+age+"\n性别："+sex+"\n售出价格："+priceOut+"\n是否注射过狂犬疫苗："+s;
    }
}
