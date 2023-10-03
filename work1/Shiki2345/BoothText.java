package booth;

public class BoothText {
    public static void main(String[] args) {
        Booth Booth = new Booth(1, "西瓜摊",30, false );
        System.out.println(Booth.toString());

        Booth.purchase(Booth,20);
        Booth.restock(30);
        System.out.println(Booth.toString());
    }
}
