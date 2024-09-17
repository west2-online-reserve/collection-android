public class Beagles extends Animal{
    // 判断一下比格犬的拆家能力
    private String demolitionAbility;
    // 构造函数
    public Beagles(String name, int age, String gender, double price, double cost, String demolitionAbility) {
        super(name, age, gender, price, cost);
        this.demolitionAbility = demolitionAbility;
    }

    @Override
    public String toString() {
        return "Beagles: " + name + "\n"
                +"Age: " + age + "\n"
                +"Gender: " + gender + "\n"
                +"Demolition Ability"+ demolitionAbility;
    }
}
