public class Booth{
    private long id;
    private String name;
    private int total;
    private boolean isClosed;

    public Booth(long id, String name, int total, boolean isClosed) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.isClosed = isClosed;
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

    public String toString() {
        return "Watermelon Stand [id=" + id + ", name=" + name + ", total=" + total + ", isClosed=" + isClosed + "]";
    }
    public static void purchase(Booth booth, int num) {
        if (booth.isClosed()) {
            System.out.println("This stand is closed, cannot purchase.");
            return;
        } else if (num <= 0) {
            System.out.println("Invalid quantity, please enter a positive integer.");
            return;
        } else if (num > booth.getTotal()) {
            System.out.println("Invalid quantity, please enter a number less than or equal to the stock.");
            return;
        } else {
            booth.setTotal(booth.getTotal() - num);
            System.out.println("Purchased " + num + " watermelons successfully.");
            return;
        }
    }
    public void restock(int restockNumber) {
        if (restockNumber > 200) {
            System.out.println("The purchase quantity exceeds the limit. Cannot purchase!");
            return;
        } else if (isClosed) {
            System.out.println("The booth is closed. Cannot purchase!");
            return;
        } else {
            total += restockNumber;
            System.out.println("Purchase successfully!");
        }
    }
    public static void closeBooths(Booth[] booths) {
        for (Booth booth : booths) {
            if (!booth.isClosed()) {
                booth.isClosed=true;
            }
            else{
                System.out.println(booth.toString());
            }
        }
    }
}
