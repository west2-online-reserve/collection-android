package work2.mqyxrmwdxh.regex;

import java.util.regex.Pattern;

/**
 * @author 32867
 */
public class Bonus2 {
    public static void main(String[] args) {
        JudgeString test = new JudgeString("sfafj@qq.com");
        if (test.isLegal()) {
            System.out.println("正确邮箱地址");
        } else {
            System.out.println("错误邮箱地址");
        }

        test.setEmail("24383.@ff.s.s._con");
        if (test.isLegal()) {
            System.out.println("正确邮箱地址");
        } else {
            System.out.println("错误邮箱地址");
        }

        test.setEmail("25435@sfh.sf.com");
        if (test.isLegal()) {
            System.out.println("正确邮箱地址");
        } else {
            System.out.println("错误邮箱地址");
        }
    }
}

class JudgeString {
    String email;
    static String regex = "^(\\w+([-.][a-z0-9A-Z]+)*){3,18}@\\w+([-.][a-z0-9A-Z]+)*\\.[a-zA-Z]+$";

    JudgeString(String email) {
        this.email = email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    boolean isLegal() {
        if ((email != null) && (!email.isEmpty())) {
            return Pattern.matches(regex, email);
        } else {
            return false;
        }

    }
}
