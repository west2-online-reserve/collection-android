import java.time.LocalDate;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        MyAnimalShop AnimalShop = new MyAnimalShop(100, LocalDate.of(2023,11,5));

        AnimalShop.close();

        ArrayList<String> animals = new ArrayList<String>();

        ArrayList<String> customers = new ArrayList<String>();

        Customer customer = new Customer("小明",0);
        Animal dog = new ChineseRuralDog("小黄",5,"雌性",true);

        AnimalShop.buyNewAnimal(dog);
        AnimalShop.treatCustomer(customer,dog);


    }
}
