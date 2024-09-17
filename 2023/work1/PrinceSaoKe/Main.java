package work1.PrinceSaoKe;

public class Main {
    public static void main(String[] args) {
        Booth myBooth = new Booth(1, "我的瓜摊", 10, false);
        System.out.println(myBooth.toString());
        Booth.purchase(myBooth, 20);
        myBooth.restock(50);
        System.out.println(myBooth.toString());
        Booth.purchase(myBooth, 20);
        Booth[] boothArray = { myBooth };
        Booth.closeBooths(boothArray);
    }
}
