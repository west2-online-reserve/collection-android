package work2.mqyxrmwdxh.animalshop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 32867
 */
public class Customer {
    private String name;
    private int visitNum;
    private LocalDate latestTime;
    private List<AbstractAnimal> petList;

    Customer(String name) {
        visitNum = 0;
        this.name = name;
        petList = new ArrayList<AbstractAnimal>();
    }

    public void addPet(AbstractAnimal pet) {
        petList.add(pet);
    }

    public void getPetList() {
        for (int i = 0; i < petList.size(); i++) {
            System.out.println("顾客" + name + "的第" + (i + 1) + "个宠物: " + petList.get(i));
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LocalDate getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(LocalDate latestTime) {
        this.latestTime = latestTime;
    }

    public void addVisitNum() {
        this.visitNum++;
    }

    public int getVisitNum() {
        return visitNum;
    }

    @Override
    public String toString() {
        return "顾客----姓名：" + name + ",到店次数：" + visitNum + ",最新到到店时间：" + latestTime;
    }
}
