public class Test {
    public static void main(String[] args) {
        Booth[] booths=new Booth[4];
        booths[0]=new Booth(0,"张三",0,true);
        booths[1]=new Booth(0,"李四",100,false);
        booths[2]=new Booth(0,"王五",20,false);
        booths[3]=new Booth(0,"赵六",50,true);
        Booth.closeBooths(booths);
    }
}
