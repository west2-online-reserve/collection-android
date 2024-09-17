package booth;

public class BoothTest {
    public static void main(String[] args) {
        Booth Booth = new Booth(1, "西瓜摊",30, false );
        System.out.println(Booth.toString());
        Booth.purchase(Booth,20);
        Booth.restock(30);
        System.out.println(Booth.toString());

        Booth Booth2 = new Booth(2, "测试西瓜摊",50, false );
        System.out.println(Booth2.toString());
        Booth.purchase(Booth,200);
        Booth.restock(300);
        System.out.println(Booth.toString());

        Booth Booth3 = new Booth(3, "测试西瓜摊",50, true );
        System.out.println(Booth3.toString());
        Booth.purchase(Booth,-5);
        Booth.restock(50);
        System.out.println(Booth.toString());
    }
}
