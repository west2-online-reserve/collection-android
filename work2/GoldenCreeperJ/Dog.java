package GoldenCreeperJ;
/**
 * @author GoldenCreeperJ
 * @date 2023/11/7
 */
public class Dog extends Animal{
    public Dog(String name, int age, String gender){
        super(name,age,gender,300);
    }

    public Dog() {
    }

    @Override
    public String toString() {
        return "\n name:"+this.name+"\n age:"+this.age+"\n gender:"+this.gender+"\n price:"+this.price+"\n";
    }
}
