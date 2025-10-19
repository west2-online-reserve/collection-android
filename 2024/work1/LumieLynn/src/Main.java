public class Main {
    public static void main(String[] args) {
        // Shop
        MyAnimalShop La_Soleil = new MyAnimalShop(300);

        // Animals
        Cat Shokora = new Cat("Shokora",18,false);
        Cat Banira = new Cat("Banira",17,false);
        Cat Shisho = new Cat("Shisho",5,true);
        Cat Kokonasu = new Cat("Kokonasu",18,false);
        ChineseRuralDog Gorou = new ChineseRuralDog("Gorou",18,true,true);

        // Customer
        Customer Minazuki_Shigure = new Customer("Minazuki_Shigure",0,null);
        Customer Murasame = new Customer("Murasame",0,null);

        // Shop features

        // Add initial pets
        La_Soleil.AddInitialAnimal(Shokora);
        La_Soleil.AddInitialAnimal(Kokonasu);
        // Open shop
        La_Soleil.OpenShop();
        // Buy Pets
        try{
            La_Soleil.Buyin(Shisho);
            La_Soleil.Buyin(Banira);
        } catch (InsufficientBalanceException e) {
            e.printStackTrace();
        }
        // Entertain Customer
        try {
            La_Soleil.EntertainCustomer(Minazuki_Shigure,Shokora);
            La_Soleil.EntertainCustomer(Murasame,Gorou);
        } catch (AnimalNotFoundException e) {
            e.printStackTrace();
        }
        // Close Shop
        La_Soleil.CloseShop();
        // Open for a second time
        La_Soleil.OpenShop();
        try{
            La_Soleil.Buyin(Gorou);
        } catch (InsufficientBalanceException e) {
            e.printStackTrace();
        }
        try{
            La_Soleil.EntertainCustomer(Murasame,Gorou);
            La_Soleil.EntertainCustomer(Minazuki_Shigure,Kokonasu);
        } catch (AnimalNotFoundException e) {
            e.printStackTrace();
        }
        La_Soleil.CloseShop();
    }
}