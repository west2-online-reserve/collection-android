package GoldenCreeperJ;
/**
 * @author GoldenCreeperJ
 * @date 2023/11/7
 */
public class Cat extends Animal{

    public Cat(String name, int age, String gender){
        super(name,age,gender,200);
    }

    public Cat() {
    }

    @Override
    public String toString() {
        return "\n name:"+this.name+"\n age:"+this.age+"\n gender:"+this.gender+"\n prece:"+this.price+"\n";
    }
}
