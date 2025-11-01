package AnimalShop.Animals;

import AnimalShop.Animal;

public class Dog extends Animal {
    boolean isVaccineInjected;

    public Dog(char sex, String name, int age,boolean isVaccineInjected) {
        super(sex, name, age, 200);
        this.isVaccineInjected = isVaccineInjected;
    }

    @Override
    public String toString() {
        return ("[一只小狗狗：名字是:"+name
                +" 性别是:"+sex
                +" 年龄是:"+age
                +" 价格是:"+cost
                +"]"
        );
    }

    public void VaccineInjected() {
        if(isVaccineInjected){
            System.out.println("疫苗已经打过了，不需要再打了~");
        }
        else{
            isVaccineInjected=true;
            System.out.println("成功打上疫苗了~");
        }
    }
}



