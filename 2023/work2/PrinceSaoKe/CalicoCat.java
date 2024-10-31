package work2.PrinceSaoKe;

public class CalicoCat extends Animal {

    public CalicoCat(String name, int age, Sex sex) {
        super(name, age, 200, sex);
    }

    @Override
    public String toString() {
        return "狸花猫，名字：" + name + "，年龄：" + age + "岁，性别：" + sex + "，价格：" + price + "元";
    }
}
