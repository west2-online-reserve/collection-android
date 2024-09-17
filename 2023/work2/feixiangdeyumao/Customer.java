package AnimalShop;

import java.time.LocalDate;

/**
 * @version 1.0 2023.10.31
 * @author feixiangdeyumao
 */
public class Customer {

    private String customerName;
    private int timesOfVisits;
    private LocalDate lastVisitTime;
    public Customer(){
        customerName = "Nobody";
        timesOfVisits = 0;
        lastVisitTime = LocalDate.now();
    }
    public Customer(String customerName, int timesOfVisits){
        this.customerName = customerName;
        this.timesOfVisits = timesOfVisits;
    }
    @Override
    public String toString(){
        return "This customer is called " + customerName + ", his/her visits here " + timesOfVisits + " times. Last visit date is " + lastVisitTime;
    }

    public void addTimesOfVisits(){
        timesOfVisits ++;
    }

    public void updateLastVisitTime(LocalDate latestDay){
        lastVisitTime = latestDay;
    }

    public String getCustomerName(){
        return customerName;
    }

    public int getTimesOfVisits() {
        return timesOfVisits;
    }

    public LocalDate getLastVisitTime() {
        return lastVisitTime;
    }
}
