public class Bonus2Test {
    public static void main(String[] args) {
        String email1 = "test@example.com";
        String email2 = "invalid-email";

        System.out.println(Bonus2.isEmailValid(email1)); // true
        System.out.println(Bonus2.isEmailValid(email2)); // false
    }
}
