public class Main {
    static void main() {

        var pass = true;
        try {
            Test.normalTest();
        } catch (Exception exception) {
            System.out.println("NormalTest: FAILED!");
            System.out.println("Error Message: " + exception.getMessage());
            pass = false;
        }
        if (pass) {
            System.out.println("NormalTest: PASS!");
        }

        System.out.println("-------------------------------");

        pass = false;
        try {
            Test.buyNotStockAnimalTest();
        } catch (AnimalNotFoundException exception) {
            System.out.println("BuyNotStockAnimal: PASS!");
            System.out.println("Error Message: " + exception.getMessage());
            pass = true;
        }
        if (!pass) {
            System.out.println("BuyNotStockAnimal: FAILED!");
        }

        System.out.println("-------------------------------");

        pass = false;
        try {
            Test.insufficientBalanceTest();
        } catch (InsufficientBalanceException exception) {
            System.out.println("InsufficientBalanceTest: PASS!");
            System.out.println("Error Message: " + exception.getMessage());
            pass = true;
        }
        if (!pass) {
            System.out.println("InsufficientBalanceTest: FAILED!");
        }


    }
}
