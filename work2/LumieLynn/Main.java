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

        //Set Initial Pets
        La_Soleil.setInitialAnimal(Shokora);
        La_Soleil.setInitialAnimal(Banira);
        La_Soleil.setInitialAnimal(Azuki);
        La_Soleil.setInitialAnimal(Kokonasu);
        //Open Shop
        La_Soleil.openShop();
        //Buy Pets
        La_Soleil.buyNewAnimals(Shisho);
        La_Soleil.buyNewAnimals(Gorou);
        //Entertain Customer
        La_Soleil.entertainCustomer(Minazuki_Shigure,Azuki);
        La_Soleil.entertainCustomer(Maniwa_Roka,Kokonasu);
        La_Soleil.entertainCustomer(Murasame,Meipuru);
        //Close Shop
        La_Soleil.closeShop();
        //Open for a second time
        La_Soleil.openShop();
        La_Soleil.buyNewAnimals(Gorou);
        La_Soleil.closeShop();

    }
}
