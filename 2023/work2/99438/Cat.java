public class Cat extends Animal {
    // 您好小猫绝育了吗
    private boolean isSterilized;
    // 构造函数
    public Cat(String name, int age, String gender, double price, double cost, boolean isSterilized) {
        super(name, age, gender, price, cost);
        this.isSterilized = isSterilized;
    }

    @Override
    public String toString() {
        return "Cat: " + name + "\n"
                +"Age: " + age + "\n"
                +"Gender: " + gender + "\n"
                +"IsisSterilized: "+ isSterilized;
    }
}
