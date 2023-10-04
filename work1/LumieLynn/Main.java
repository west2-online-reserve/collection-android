package LumieLynn;

public class Main {
	public static void main(String[] args) {
		WatermelonBooth booth1 = new WatermelonBooth(1,"First booth",25,false);
		System.out.println(booth1.toString());
		WatermelonBooth.purchase(booth1, 5);
		booth1.restock(50);
		System.out.println(booth1.toString());
		WatermelonBooth[] booths = {booth1};
		WatermelonBooth.closeBooths(booths);
		System.out.println(booth1.toString());
	}

}
