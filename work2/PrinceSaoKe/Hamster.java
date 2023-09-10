package work2.PrinceSaoKe;

public class Hamster extends Animal {
    public Hamster(String name, int age, Sex sex) {
        super(name, age, 10, sex);
    }

    @Override
    public String toString() {
        return "仓鼠，名字：" + name + "，年龄：" + age + "岁，性别：" + sex + "，价格：" + price + "元";
    }
}
