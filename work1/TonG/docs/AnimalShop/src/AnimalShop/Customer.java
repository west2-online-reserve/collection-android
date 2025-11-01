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
        return (name+"的到店次数是:"+count+"\n"
        +"最新到店时间为:"+date.toString()+"\n——————————————————————————————————————"
        );
    }
}
