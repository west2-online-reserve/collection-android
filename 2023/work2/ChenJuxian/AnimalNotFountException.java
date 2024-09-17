public class AnimalNotFountException extends RuntimeException{
    public AnimalNotFoundException(String message) {  //自定义异常
        super(message);
    }
}
