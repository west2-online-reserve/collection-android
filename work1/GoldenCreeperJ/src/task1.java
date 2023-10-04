public class task1 {
    public static void main(String[] args){
        Booth booth1 = new Booth(1000,"xiaoming",150,false);
        Booth booth2 = new Booth(1001,"xiaohoong",100,true);
        Booth[] booths = {booth1,booth2};

        System.out.println(booth1);
        System.out.println(booth2);

        booth1.restock(-1);
        booth1.restock(201);
        booth1.restock(50);

        Booth.purchase(booth1,-1);
        Booth.purchase(booth1,201);
        Booth.purchase(booth1,50);
        Booth.purchase(booth2,50);

        Booth.closeBooths(booths);
        Booth.purchase(booth1,50);
    }
}
class Booth {

    private long id;
    private String name;
    private int total;
    private boolean isClosed;


    public Booth(long id, String name, int total, boolean isClosed){
        this.id=id;
        this.name=name;
        this.total = total;
        this.isClosed=isClosed;
    }


    public static void purchase(Booth booth, int watermelon_num){
        if(booth.isClosed){
            System.out.println("商家处于休摊整改状态");
        }else if(watermelon_num<=0){
            System.out.println("购买的西瓜数必须为正数");
        }else if(watermelon_num> booth.total){
            System.out.println("购买西瓜数不能大于在售西瓜数");
        }else {
            System.out.println("交易成功");
            booth.total-=watermelon_num;
        }
    }

    public static void closeBooths(Booth[] booths){
        for(Booth i: booths){
            if(i.isClosed){
                System.out.println(i);
            }else {
                i.isClosed=true;
            }
        }
    }


    @Override
    public String toString() {
        return "\n id:"+this.id+"\n name:"+this.name+"\n total:"+this.total+"\n isClosed:"+this.isClosed+"\n";
    }



    public void restock(int watermelon_num){
        if(watermelon_num>200){
            System.out.println("单次进货量不能超过 200");
        }else if(watermelon_num<0){
            System.out.println("单次进货量不能低于 0");
        }else{
            this.total+=watermelon_num;
        }
    }

    public long getId() {
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

}
