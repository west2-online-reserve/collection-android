
public class Main {
    public static void main(String[] args) {
        //构造方法测试
        MelonBooth m1 = new MelonBooth(1,"刘滑墙",100,true);
        MelonBooth[] booths = new MelonBooth[5];
        booths[0] = new MelonBooth(1001,"12345",1,false);
        booths[1] = new MelonBooth(1008,"abc",0,true);
        booths[2] = new MelonBooth(2006,"!@#$%",999,false);
        booths[3] = new MelonBooth(3060,"姓名",500,true);
        booths[4] = new MelonBooth(4090,"西瓜",1024,false);
        System.out.println("**********");

        //toString方法测试
        System.out.println(m1);
        System.out.println("**********");

        //各变量对应的set和get方法测试
        m1.setId(2);
        System.out.println("当前摊号：" + m1.getId());
        m1.setName("老板");
        System.out.println("摊主姓名：" + m1.getName());
        m1.setTotal(200);
        System.out.println("当前在售西瓜数：" + m1.getTotal());
        m1.setIsClosed(false);
        System.out.println("是否休摊整改：" + m1.getIsClosed());
        System.out.println("**********");

        //purchase方法测试
        /*休摊*/
        MelonBooth.purchase(booths[1], 1);
        /*正常购买*/
        MelonBooth.purchase(booths[0], 1);
        /*缺货*/
        MelonBooth.purchase(booths[0], 1);
        /*买0个*/
        MelonBooth.purchase(booths[2], 0);
        /*买负数个*/
        MelonBooth.purchase(booths[2], -100);
        /*正常购买*/
        MelonBooth.purchase(booths[2], 998);
        System.out.println("**********");

        //restock方法测试
        /*正常进货*/
        booths[0].restock(100);
        booths[0].restock(200);
        /*非正常进货*/
        booths[0].restock(9999);
        booths[0].restock(-999);
        booths[0].restock(0);
        System.out.println("**********");

        /*更改*/
        
        //closeBooths方法测试
        MelonBooth.closeBooths(booths);
        System.out.println("**********");
        MelonBooth.closeBooths(booths);
        for (MelonBooth mb : booths) {
            mb.setIsClosed(false);
        }
        MelonBooth.closeBooths(booths);
    }
}
