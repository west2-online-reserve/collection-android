public class Cat extends Animal{
    public Cat(String name, int age, String gender) {
        super(name, age, 200.0, gender);
    }
    public String toString() {
        return String.format("该猫猫信息如下：名字：%s 年龄：%d 性别：%s " +
                "价格：%.2f", getName(), getAge(), getGender(), getPrice());
    }
}
