import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MelonBooth []booths=new MelonBooth[2];
        booths[0]= new MelonBooth(1,"麒麟瓜摊位",30,false);
        booths[1]= new MelonBooth(2,"无籽西瓜摊位",25,false);
        System.out.println(booths[0].toString());
        MelonBooth.purchase(booths[0],20);
        booths[0].restock(50);
        booths[1].restock(10);
        booths[0].setClosed(true);
        MelonBooth.closeBooths(booths);
        MelonBooth.purchase(booths[0],10);
    }
}