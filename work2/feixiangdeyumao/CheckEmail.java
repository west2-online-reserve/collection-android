package AnimalShop;
/**
 * @version 1.0 2023.10.31
 * @author feixiangdeyumao
 */
import java.util.Scanner;
import java.util.regex.*;

public class CheckEmail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 请求用户输入
        System.out.print("Input an email address:");
        String inputEmail = scanner.nextLine();

        // 检查是否匹配正确格式
        if (checkEmail(inputEmail)) {
            System.out.println("Valid!");
        } else {
            System.out.println("Invalid!");
        }
    }

    public static boolean checkEmail(String email) {
        // 定义邮箱正则表达式
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // 编译正则表达式
        Pattern pattern = Pattern.compile(emailRegex);

        // 创建匹配器
        Matcher matcher = pattern.matcher(email);

        // 返回匹配结果
        return matcher.matches();
    }
}
