public class Elephant extends Animal{
    boolean isVaccineInjected;

    int ElephantPrice = 10000;
    private String sort;


    @Override
    public String toString() {
        String Vaccine;
        if (isVaccineInjected){
            Vaccine="已注射疫苗";
        }else {
            Vaccine="未注射疫苗";
        };
        return " 名字："+name+" 年龄："+age+" 性别："+sex+" 售出价格："+ElephantPrice+" 是否注射过狂犬疫苗："+Vaccine;
    }

    public Elephant(String name, int age, String sex, int price,boolean isVaccineInjected) {
        super(name, age, sex);
        this.price=ElephantPrice;
        this.isVaccineInjected=isVaccineInjected;
        this.sort = "猫猫";


    }

}
