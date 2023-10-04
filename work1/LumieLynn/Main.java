package LumieLynn;
public class Main {
	public static void main(String[] args) {
		WatermelonBooth booth1 = new WatermelonBooth(1,"First booth",25,false);
		WatermelonBooth booth2 = new WatermelonBooth(2,"Second booth",20,true);
		System.out.println(booth1.toString());
		System.out.println(booth2.toString());
		WatermelonBooth.purchase(booth1, 5);
		WatermelonBooth.purchase(booth2, 10);
		WatermelonBooth.purchase(booth1, -10);
		WatermelonBooth.purchase(booth1, 65);
		booth1.restock(50);
		booth1.restock(1000);
		booth2.restock(-100);
		System.out.println(booth1.toString());
		WatermelonBooth[] booths = {booth1};
		WatermelonBooth.closeBooths(booths);
		System.out.println(booth1.toString());
	}

}
