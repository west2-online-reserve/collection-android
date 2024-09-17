package GoldenCreeperJ;

import java.time.LocalDate;
/**
 * @author GoldenCreeperJ
 * @date 2023/11/7
 */
public class Customer {
    private String name;
    private int arrivetimes;
    private LocalDate lastestarrivaltime;

    public Customer(String name, int arrivetimes, LocalDate lastestarrivaltime) {
        this.name = name;
        this.arrivetimes = arrivetimes;
        this.lastestarrivaltime = lastestarrivaltime;
    }

    public String getName() {
        return name;
    }

    public int getArrivetimes() {
        return arrivetimes;
    }

    public LocalDate getLastestarrivaltime() {
        return lastestarrivaltime;
    }

    public void setArrivetimes(int arrivetimes) {
        this.arrivetimes = arrivetimes;
    }

    public void setLastestarrivaltime(LocalDate lastestarrivaltime) {
        this.lastestarrivaltime = lastestarrivaltime;
    }

    @Override
    public String toString(){
        return "\n name:"+this.name+"\n arrivetimes:"+this.arrivetimes+"\n lastestarrivaltime:"+this.lastestarrivaltime+"\n";
    }
}
