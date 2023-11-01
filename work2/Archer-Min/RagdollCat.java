public class RagdollCat extends Animal{
    public RagdollCat(String name, int age, String sex) {
        super(name, age, sex, 200,300);
    }

    @Override
    public String toString() {
        return "名字："+name+"\n年龄："+age+"\n性别："+sex+"\n售出价格："+priceOut;
    }
}
