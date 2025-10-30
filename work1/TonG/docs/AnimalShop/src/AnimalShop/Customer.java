package AnimalShop;

import java.time.LocalDate;

public class Customer {
    String name;
    int count=0;
    LocalDate date;

    public Customer(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", date=" + date +
                '}';
    }
}
