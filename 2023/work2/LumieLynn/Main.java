import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Shop
        MyAnimalShop La_Soleil = new MyAnimalShop(200,false);

        //Animals
        Nekomusume Shokora = new Nekomusume(1,"Shkokra",18,false);
        Nekomusume Banira = new Nekomusume(2,"Banira",17,false);
        Nekomusume Azuki = new Nekomusume(3,"Azuki",18,false);
        Nekomusume Kokonasu = new Nekomusume(4,"Kokonatsu",21,false);
        Nekomusume Meipuru = new Nekomusume(5,"Meipuru",18,false);
        Cat Shisho = new Cat(5,"Shisho",5,true);
        ChineseRuralDog Gorou = new ChineseRuralDog(6,"Gorou",6,false,true);

        //Customer
        Customer Minazuki_Shigure = new Customer("Minazuki Shigure",1,0,null);
        Customer Maniwa_Roka = new Customer("Maniwa Roka",2,1,null);
        Customer Murasame = new Customer("Murasame",3,0,null);

        //Shop features

        //Add Initial Pets
        La_Soleil.addInitialAnimal(Shokora);
        La_Soleil.addInitialAnimal(Banira);
        La_Soleil.addInitialAnimal(Azuki);
        La_Soleil.addInitialAnimal(Kokonasu);
        //Open Shop
        La_Soleil.openShop();
        //Buy Pets
        try{
            La_Soleil.buyNewAnimal(Shisho);
            La_Soleil.buyNewAnimal(Gorou);
        } catch(InsufficientBalanceException e) {
            e.printStackTrace();
        }
        //Entertain Customer
        try{
            La_Soleil.entertainCustomer(Minazuki_Shigure,Azuki);
            La_Soleil.entertainCustomer(Maniwa_Roka,Kokonasu);
            La_Soleil.entertainCustomer(Murasame,Meipuru);
        } catch (AnimalNotFoundException e) {
            e.printStackTrace();
        }
        //Close Shop
        La_Soleil.closeShop();
        //Open for a second time
        La_Soleil.openShop();
        try{
            La_Soleil.buyNewAnimal(Meipuru);
        } catch (InsufficientBalanceException e) {
            e.printStackTrace();
        }
        try {
            La_Soleil.entertainCustomer(Murasame, Meipuru);
        } catch (AnimalNotFoundException e) {
            e.printStackTrace();
        }
        La_Soleil.closeShop();

    }
}
