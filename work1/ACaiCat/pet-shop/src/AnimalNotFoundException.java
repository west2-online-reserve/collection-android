public class AnimalNotFoundException extends RuntimeException {
    public AnimalNotFoundException(String name) {
        super(String.format("Animal not found: %s", name));
    }
}
