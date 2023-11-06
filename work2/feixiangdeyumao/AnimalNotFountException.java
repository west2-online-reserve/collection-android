package AnimalShop;

/**
 * @version 1.1 2023.11.6
 * @author feixiangdeyumao
 */
public class AnimalNotFountException extends RuntimeException{
    public AnimalNotFountException(String animalName){
        super("Cannot find this animal: " + animalName);
    }
}
