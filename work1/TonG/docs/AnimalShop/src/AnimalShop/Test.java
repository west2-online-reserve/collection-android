package AnimalShop;

import AnimalShop.Animals.Dog;
import AnimalShop.Animals.Cat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Test {

    public static void main(String[] args) {

        LocalDate date=LocalDate.now();

        MyAnimalShop shop =new MyAnimalShop();
        Animal dog1 = new Dog('M',"66",6,true);
        Animal cat1 = new Cat('S',"耄耋",6);
        Animal cat2 = new Cat('S',"哈机密",6);
        Animal dog2 = new Dog('M',"哈士奇",12,true);

        List<Animal> As=new ArrayList<>();
        As.add(dog1);
        As.add(cat1);
        As.add(cat2);

        List<Customer> Cs=new ArrayList<>();

        //初始化
        Initialize(shop,As,Cs,date);
        shop.setOn(shop.isOff());

        Test1(shop,dog1);
        Test3(shop);

        shop.saleAnimal(cat2);
        shop.buyAnimal(dog2);

        Test2(shop);//时间调到周末关门
    }




    public static void Initialize(MyAnimalShop shop,List<Animal> As,List<Customer> Cs,LocalDate date){
        date = LocalDate.of(2025, 10, 23);
        shop.setMoney(250.00);
        shop.setAnimals(As);
        shop.setCustomers(Cs);
        shop.date= date;
    }



    public static void Test1(MyAnimalShop shop,Animal a){
        shop.saleAnimal(a); //卖动物
    }

    public static void Test3(MyAnimalShop shop){
        Customer LaoWang = new Customer("老王",LocalDate.of(1989,1,1)) ;
        Customer XiaoWang = new Customer("小王",LocalDate.of(1989,1,1)) ;
        shop.treatCostumer(LaoWang);
        shop.treatCostumer(XiaoWang);

        shop.treatCostumer(LaoWang); // 测试重复顾客
        System.out.println(LaoWang.toString()); //查询顾客信息
    }

    public static void Test2(MyAnimalShop shop){
        shop.date= LocalDate.of(2025, 10, 26);
        shop.setOn(shop.isOff());
        Customer DaoMei = new Customer("倒霉蛋",LocalDate.of(1989,1,1)) ;
        shop.treatCostumer(DaoMei); //关门后还想来的话...
    }


}





