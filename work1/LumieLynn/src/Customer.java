import java.time.LocalDate;
import java.util.ArrayList;

public class Customer {
    private String name;
    private int VisitNumber;
    private LocalDate NewestArriveTime;
    ArrayList<Animal> animals = new ArrayList<>();
    public Customer(String name, int VisitNumber, LocalDate NewestArriveTime) {
        this.name = name;
        this.VisitNumber = VisitNumber;
        this.NewestArriveTime = NewestArriveTime;
    }
    public String getName() {
        return name;
    }
    public LocalDate getNewestArriveTime() {
        return NewestArriveTime;
    }

    public void setNewestArriveTime() {
        NewestArriveTime = LocalDate.now();
        VisitNumber += 1;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Customer [name=");
        builder.append(name);
        builder.append(", VisitNumber=");
        builder.append(VisitNumber);
        builder.append(", NewestArriveTime=");
        builder.append(NewestArriveTime);
        return builder.toString();
    }
}
