public class Main {
    public static void main(String[] args) {
        Booth []booths=new Booth[2];
        booths[0]= new Booth(1, "1", 50, false);
        booths[1]= new Booth(2, "2", 500, false);

        System.out.println(booths[0].toString());
        Booth.purchase(booths[1], 10);
        booths[0].restock(10);
        booths[0].setClosed(true);
        Booth.closeBooths(booths);
    }
}