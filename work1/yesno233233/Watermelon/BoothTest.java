package Watermelon;

public class BoothTest {
    public static void main(String[] args) {
        Booth booth1=new Booth(1,"Java西瓜摊",100,true);
        Booth booth2=new Booth(2,"Android西瓜摊",150,false);

        Booth.purchase(booth1,20);      //修整，失败
        Booth.purchase(booth2,100);     //成功，剩50
        Booth.purchase(booth2,100);     //超了，失败
        Booth.purchase(booth2,-2);     //小于0，失败

        booth1.restock(50);     //成功，有150了
        booth1.restock(300);    //失败，进货量大于200
        booth2.restock(-10);    //失败，进货量小于等于0

        Booth[] booths={booth1,booth2};
        Booth.closeBooths(booths);
    }
}
