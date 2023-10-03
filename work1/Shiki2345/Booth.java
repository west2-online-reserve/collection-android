package booth;
public class Booth {
    //四个私有变量
    private long id;//摊号
    private String name;//摊主姓名
    private int total;//在售西瓜数量
    private boolean isClosed;//是否休摊整改

    //四个变量对应的get/set方法：


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getName(){
        return name;
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

    //一个重写的toString()方法来输出该西瓜摊的所有信息（要有一定的格式）


    @Override
    public String toString() {
        return String.format("%d%n %s%n %d%n %b%n",id,name,total,isClosed);//****
    }
    //一个接受摊号（long）、摊主姓名（name）、在售西瓜数（int）、是否休摊整改（boolean）作为参数的构造方法
    public Booth(long id, String name, int total, boolean isClosed){
        this.id = id;
        this.name = name;
        this.total = total;
        this.isClosed = isClosed;
    }
/*
   一个静态（static）方法purchase（booth商家,int 购买数量）
   向目标摊位卖家购买指定数量的西瓜。
   购买的西瓜数必须为正数；商家不能处于休摊整改状态；
   购买西瓜数不能大于在售西瓜数；
   出现以上情况视为购买失败，摊主在售西瓜数不能有所变化。
   无论交易成功与否，都要输出一定的提示信息。
*/
public static int purchase(Booth booth,int number){
    if(number < 1){
        System.out.println("购买的西瓜数必须为正数!");
    } else if (booth.isClosed) {
        System.out.println("商家收摊咯，明天再来！");
    } else if (number > booth.total) {
        System.out.println("购买西瓜数不能大于在售西瓜数!");
    } else {
        System.out.println("购买成功！^_^");
    booth.total -= number;
    }
return booth.total;
}
/*
       一个实例方法 restock(int进货西瓜数)，
       为对应摊位进货
       单次进货量不能超过200，
       进货失败则输出相应的提示信息。
*/
    public int restock(int restock_number){
        if (restock_number >200){
            System.out.println("单次进货量不能超过200");
        }else{
            total += restock_number;
        }
        return total;
    }
/*
   一个静态（static）方法 closeBooths(Booth[] booths)
   让booths中所有未被休业整改的摊位歇业(将false变为true),
   输出已在休业整改的摊位信息（调用实例的toString()方法）
*/
public static void closeBooths(Booth[] booths){
    for (Booth booth:booths){
        if(booth.isClosed){
            System.out.println(booth.toString());
        }else{
            booth.isClosed = true;
        }
    }
}
}
