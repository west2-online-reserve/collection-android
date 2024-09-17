
public class TestBooth {

	public static void main(String[] args) {
		
		Booth newBooth = new Booth(1, "booth1", 10, false);
		
        System.out.println(newBooth.toString());//当前摊位状态
        
        Booth.purchase(newBooth, 100);//买过多西瓜
        Booth.purchase(newBooth, 10);//买适量西瓜
        
        newBooth.restock(201);//进货两次，第一次过多，第二次适量
        newBooth.restock(100);
        
        System.out.println(newBooth.toString());//进货后摊位状态
        
        Booth closeBooth = new Booth(1, "booth2", 10, true);
        Booth openBooth = new Booth(1, "booth3", 10, false);
        //用三个booth测试关闭摊位功能
        Booth[] boothArray = { newBooth, openBooth, closeBooth };
        Booth.closeBooths(boothArray);
		
	}

}