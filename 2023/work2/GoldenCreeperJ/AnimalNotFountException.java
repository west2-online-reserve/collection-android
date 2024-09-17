package GoldenCreeperJ;
/**
 * @author GoldenCreeperJ
 * @date 2023/11/7
 */
public class AnimalNotFountException extends RuntimeException{
    public AnimalNotFountException() {
    }

    @Override
    public String toString() {
        return "没找到动物!\n";
    }
}
