public class Booth {
    //创建四个私有变量
    //摊号
    private long id;
    //摊主姓名
    private String name;
    //在售西瓜数
    private int total;
    //是否休摊整改
    private boolean isClosed;

    //上述变量对应的get和set方法

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

    //一个重写的toString()方法来输出该西瓜摊的所有信息
    @Override
    public String toString() {
        System.out.println("西瓜摊的ID是：" + id);
        System.out.println("西瓜摊的摊主姓名为：" + name);
        System.out.println("西瓜摊上总共有的西瓜数量为：" + total);
        System.out.println("西瓜摊是否闭摊：" + isClosed);
        return super.toString();
    }

    //一个接受摊号（long）、摊主姓名（name） 、在售西瓜数（int）、是否休摊整改 （boolean）作为参数的构造方法
    public Booth(long id, String name, int total, boolean isClosed) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.isClosed = isClosed;
    }
    Booth[] booths;

    /*一个静态（static）方法 purchase（Booth 商家， int 购买数量），
     向目标摊位卖家 购买指定数量的西瓜。
     购买的西瓜数必须为正数；商家不能处于休摊整改状态；
     购买西瓜数不能大于在售西瓜数。
     出现以上情况视为购买失败，摊主在售西瓜数不能有所变化。
     无论交易成功与否，都要输出一定的提示信息
     */
    //先实例化Booth构造方法，使static方法能够调用
    Booth booth = new Booth(this.id, this.name, this.total, this.isClosed);
    //purchase方法
    public static int purchase(Booth booth, int number){
        if (number < 1 | number > booth.total | booth.isClosed() == true){
            System.out.println("不好意思，交易失败。");
        } else {
            System.out.println("恭喜，交易成功。");
            booth.total = booth.total - number;
        }
        return booth.total;
    }

    /*
    一个实例方法 restock（int 进货西瓜数），
    为对应摊位进货，
    单次进货量不能超过 200，
    进货失败则输出相应的提示信息。
     */
    public int restock (int restock_number){
        if (restock_number > 200) {
            System.out.println("不好意思，进货失败。");
        } else {
            total = total + restock_number;
        }
        return total;
    }

    /*
    一个静态（static）方法 closeBooths（Booth[] booths）
    让 booths 中所有未被休业整改的摊位歇业（将 false 变为 true），
    输出已在休业整改的摊位信息（调用实例的 toString（）方法）。
     */
    public static void closeBooths(Booth[] booths){
        for (int i = 0; i < booths.length; i++) {
            if (booths[i].isClosed == false ) {
                booths[i].isClosed = true;
            }
            booths[i].toString();
        }
    }
}
