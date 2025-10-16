import java.util.ArrayList;

public class Test {
    public static void normalTest() {
        var shop = new MyAnimalShop(114514.0, new ArrayList<>());
        var cat = new Cat("哈基米", 1, true, 999.0, true);
        var dog = new Dog("Doge", 5, true, 233.0, true);
        shop.buyNewAnimal(cat);
        shop.buyNewAnimal(dog);
        shop.entertainCustomer("uz", "哈基米");
        shop.entertainCustomer("uz", "Doge");
        shop.close();
    }

    public static void buyNotStockAnimalTest() {
        var shop = new MyAnimalShop(114514.0, new ArrayList<>());
        var cat = new Cat("哈基米", 1, true, 999, true);
        shop.buyNewAnimal(cat);
        shop.entertainCustomer("uz", "耄耋");
    }

    public static void insufficientBalanceTest() {
        var shop = new MyAnimalShop(233.0, new ArrayList<>());
        var cat = new Cat("哈基米", 1, true, 999.0, true);
        shop.buyNewAnimal(cat);
    }
}
