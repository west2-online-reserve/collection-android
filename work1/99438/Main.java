public class Main {
    public static void main(String[] args) {
        Booth []booths=new Booth[2];
        booths[0]= new Booth(1, "1", 50, false);
        booths[1]= new Booth(2, "2", 500, false);

        System.out.println(booths[0].toString());
        Booth.purchase(booths[1], 10);
        Booth.purchase(booths[1], -10);
        Booth.purchase(booths[1], 600);
        booths[1].setClosed(true);
        booths[1].restock(10);
        System.out.println(booths[1].toString());
        booths[1].restock(300);
        booths[1].setClosed(false);
        booths[0].setClosed(true);
        Booth.closeBooths(booths);
    }
}
