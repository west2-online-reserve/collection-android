public class ChineseRuralDog extends Animal{
    private boolean isVaccineInjected;
    public ChineseRuralDog(String name, int age, String gender) {
        super(name, age, 100.0, gender);
        isVaccineInjected = true;
    }
    public String toString(){
        return String.format("该中华田园犬信息如下：名字：%s 年龄：%d 性别：%s " +
                "价格：%.2f 是否接种疫苗：%s", getName(), getAge(), getGender(),
                getPrice(), (isVaccineInjected) ? "是" : "否");
    }
}
