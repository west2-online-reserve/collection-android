
public class Booth {
	
	private long id;
	private String name;
	private int tota;
	private boolean isClosed;
	
	public Booth() {
		id = 1;
		name = "HuaQiang's booth";
		tota = 10;
		isClosed = false;
	}
	
	public Booth(long id, String name, int tota, boolean isClosed) {
		this.id = id;
		this.name = name;
		this.tota = tota;
		this.isClosed = isClosed;
	}
	
	public static void purchase(Booth booth, int purchaseNumber) {
		if(booth.isClosed || purchaseNumber > booth.tota || purchaseNumber < 0) {
			System.out.println("Invalid condition, cannot finish purchasing");
		}
		else {
			booth.tota -= purchaseNumber;
			System.out.println("Succsess to purchase!");
		}
	}
	
	public void restock(int stockNumber) {
		if(stockNumber <= 200 && stockNumber >= 0) {
			tota += stockNumber;
			System.out.println("Success to stock!");
		}
		else {
			System.out.println("Failed to stock!");
		}
	}
	
	public static void closeBooths(Booth[] booths) {
		System.out.println("Closing booths below: ");
		for(int i = 0; i < booths.length; i++) {
			if(!booths[i].isClosed) {
				booths[i].isClosed = true;
				System.out.println(booths[i].toString());
			}
		}
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getTota() {
		return tota;
	}
	
	public boolean getIsClosed() {
		return isClosed;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTota(int tota) {
		this.tota = tota;
	}
	
	public void setIsClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}
	
	@Override
	public String toString() {
		return 
				"The id of booth : "+ id + ",name : " + name + ", watermalons : " + tota + ", is this booth closed? : " + isClosed;
	}
}