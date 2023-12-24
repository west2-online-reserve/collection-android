package GoldenCreeperJ;
/**
 * @author GoldenCreeperJ
 * @date 2023/11/7
 */
public class ChineseRuralDog extends Animal{
    private boolean isVaccineInjected;

    public ChineseRuralDog(String name, int age, String gender,boolean isVaccineInjected){
        super(name,age,gender,100);
        this.isVaccineInjected = isVaccineInjected;
    }

    public ChineseRuralDog(){
    }

    public boolean isVaccineInjected() {
        return isVaccineInjected;
    }

    public void setVaccineInjected(boolean vaccineInjected) {
        isVaccineInjected = vaccineInjected;
    }

    @Override
    public String toString() {
        return "\n name:"+this.name+"\n age:"+this.age+"\n gender:"+this.gender+"\n price:"+this.price+"\n isVaccineInjected:" + this.isVaccineInjected + "\n";
    }


}
