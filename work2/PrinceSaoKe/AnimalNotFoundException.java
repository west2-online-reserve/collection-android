package work2.PrinceSaoKe;

public class AnimalNotFoundException extends RuntimeException {

    public AnimalNotFoundException print() {
        System.out.println("店内没有该动物！");
        return this;
    }

}
