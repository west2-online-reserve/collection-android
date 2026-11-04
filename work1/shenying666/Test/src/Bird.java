public class Bird extends Animal {
    public Bird(String name, int age, String gender) {
        super(name, age, 350.0, gender);
    }
    public String toString() {
        return String.format("该小鸟信息如下：名字：%s 年龄：%d 性别：%s 价格：%.2f",
                getName(), getAge(), getGender(), getPrice());
    }
}
