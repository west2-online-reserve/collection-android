package example.pet.customer;

import java.time.LocalDate;

public class Customer {

    protected String name;
    protected int times;
    protected LocalDate lastJoinShop;

    public Customer(String name, int times) {
        this.name = name;
        this.times = times;
        this.lastJoinShop = LocalDate.now();
    }

    public String getName() {
        return name;
    }
    public int getTimes() {
        return times;
    }

    public LocalDate getLastJoinShop() {
        return lastJoinShop;
    }

    public void updateLastJoinShop() {
        lastJoinShop = LocalDate.now();
    }

    public String toString() {
        return """
                { "name": "%s", "times": %d, "lastJoinShop": "%s" }"""
                .formatted(name, times, lastJoinShop);
    }

}
