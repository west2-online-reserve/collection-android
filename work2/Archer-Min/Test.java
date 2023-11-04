import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        MyAnimalShop myAnimalShop = new MyAnimalShop(200, LocalDate.of(2023, 8, 20));
        RagdollCat ragdollCat1 = new RagdollCat("布偶", 3, "母");
        RagdollCat ragdollCat2 = new RagdollCat("蓝双", 5, "母");
        RagdollCat ragdollCat3 = new RagdollCat("拿破仑", 2, "母");
        ChineseRuralDog chineseRuralDog1 = new ChineseRuralDog("wang", 8, "公", true);
        ChineseRuralDog chineseRuralDog2 = new ChineseRuralDog("kaka", 8, "公", true);
        myAnimalShop.buyNewAnimal(chineseRuralDog1);
        myAnimalShop.buyNewAnimal(ragdollCat1);
        myAnimalShop.buyNewAnimal(ragdollCat2);
        myAnimalShop.buyNewAnimal(chineseRuralDog2);
        Customer customer1 = new Customer("Archer", 0);
        Customer customer2 = new Customer("lele", 0);
        myAnimalShop.treatCustomer(customer1, ragdollCat1);
        myAnimalShop.treatCustomer(customer1, chineseRuralDog1);
        myAnimalShop.treatCustomer(customer2, chineseRuralDog2);

        myAnimalShop.close();

        System.out.println("第二天");
        myAnimalShop.open();
        myAnimalShop.buyNewAnimal(ragdollCat3);
        myAnimalShop.treatCustomer(customer1, ragdollCat3);
        myAnimalShop.close();
    }
}
