package work2.hexiaohei;

/**
 * @version 1.0 2023.10.13
 * @author hexiaohei
 */
public class AnimalNotFoundException extends RuntimeException{
    public AnimalNotFoundException printClue(){
        System.out.println("不好意思，该宠物已经有人领走咯");
        return this;
    }
}
