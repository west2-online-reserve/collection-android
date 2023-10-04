package chenjuxian;

import com.baidu.www.booth.Booth;

public class melonbooth {



}
    //创建四个私有变量                        1
    private long id;
    //摊主姓名
    private String name;
    //在售西瓜数
    private int total;
    //是否休摊整改
    private boolean isClosed;

    //上述变量对应的get和set方法              2


    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    //一个重写的toString()方法来输出该西瓜摊的所有信息（要有一定的格式）     3
    @Override
    public String toString() {
        return String.format( " %d%n %s%n %d%n %b%n", id, name, total, isClosed);
    }

    //一个接受摊号（long）、摊主姓名（name） 、在售西瓜数（int）、是否休摊整改 （boolean）作为参数的构造方法
    public Booth(long id, String name, int total, boolean isClosed) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.isClosed = isClosed;
    }

    //一个静态（static）方法 purchase（Booth 商家， int 购买数量），    4
    public static int purchase(Booth booth, int number){
        if (number < 1 ){
            System.out.println("购买的西瓜数必须为正数");
        } else if(booth.isClosed) {
            System.out.println("商家正处于休摊整改状态，不可购买");
        } else if (number > booth.total){
            System.out.println("购买西瓜数不能大于在售西瓜数");
        } else {
            System.out.println("购买成功！");
            booth.total -= number;
        }

        return booth.total;
    }


    //一个实例方法 restock（int 进货西瓜数）               5
    public int restock (int restock_number){
        if (restock_number > 200) {
            System.out.println("单次进货量不能超过 200");
        } else {
            total += restock_number;
        }
        return total;
    }

        //一个静态(static)方法 closeBooths（Booth[] booths）           6

