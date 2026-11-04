package example.pet.exception;

public class AnimalNotFoundException extends RuntimeException {

    public AnimalNotFoundException() {
        super("Animal Not Found");
    }

}
