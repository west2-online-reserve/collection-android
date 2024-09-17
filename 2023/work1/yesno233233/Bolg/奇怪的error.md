# 奇怪的error——问GPT
## 力扣
提交的时候，类名记得改成Main，因为力扣里运行的文件是Main.java,类名要和文件名一致
## 输入
记得在类的上面（最上面）打出“输入头文件”
``` java
import java.util.Scanner;
```
然后在类里面还要在输入前面定义一下scan(或者想要scanf什么的都可以)，下一行定义的时候输入，记得驼峰原则，

double类型用nextDouble，int类型用nextInt
``` java
Scanner scan = new Scanner(System.in);
        double centimeter = scan.nextDouble();
```

## 输出两位小数（类似的）
``` java
double salary;
System.out.printf("%.2f",salary);
```
注意是printf不是println
不管是double还是float，%.2f都是f不是d（.几就是保留几位）
## if判断两个字符是否相等
``` java
if (ope =='+') {
        c=a+b;
        } 
/*注意字符char不是字符串string
char的时候不能用equals
而且不是双引号是单引号
*/


//字符串的判断方法
if(a.equals(b)){
}

//输入字符char
import java.util.Scanner;
Scanner scanner = new Scanner(System.in);
char c = scanner.next().charAt(0);	



```