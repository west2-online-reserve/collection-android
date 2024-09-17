/**
 * @Author：realzhenikun
 * @Project：PetShop
 * @Date：2023/11/6
 * @Filename：AnimalNotFoundException
 */
public class AnimalNotFoundException extends RuntimeException {
    public AnimalNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
