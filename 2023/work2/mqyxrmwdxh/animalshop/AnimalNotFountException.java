package work2.mqyxrmwdxh.animalshop;

/**
 * @author 32867
 */
public class AnimalNotFountException extends RuntimeException {
    public AnimalNotFountException alarm() {
        System.out.println("店内没有此种宠物！");
        return this;
    }
}
