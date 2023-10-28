# format
Java中的format占位符包括：

* %s：字符串类型
* %d：整数类型（十进制）
* %f：浮点类型
* %t：日期/时间类型

其中，%t又包括以下子占位符：

* %tY：四位年份
* %ty：两位年份
* %tm：月份（01-12）
* %td：日期（01-31）
* %tH：小时（00-23）
* %tM：分钟（00-59）
* %tS：秒（00-60）

# 输入开店时间与时间判断（LocalDate）

要初始化LocalDate类型的变量，可以使用静态工厂方法of（），例如：

LocalDate date = LocalDate.of(2021, 9, 1);

这将创建一个表示2021年9月1日的LocalDate对象。

LocalDate有好多方法，根据其方法名能大概猜测它的功能，多试试便能知道适不适用。不清楚的就上csdn[doge]。


# 接口
接口里面只有功能。这些功能需要实现它的类通过具体的方法来实现。还在继续学习了解中。

# 抽象类
抽象类真的好抽象。。。还在继续学习了解中。。。

# ArrayList 与 LinkedList
ArrayList 可以动态增缩的一个索引序列

LinkedList 可任意位置高效添删的一个有序序列

# 杂记
![1](https://img-blog.csdnimg.cn/b0f792ea5ede4de0847ba7711c5b1213.png#pic_center)
若Customer类中没有重写toString方法，那么，打印Customer类型的对象customer时，输出这么一串字符串：com.hexiaohei.work02.pet.Customer@378bf509。
前面是对象所属的类名，后面是对象的哈希码。

存入列表的元素，其仍然可以通过get方法得到每个元素所有的属性（当然，要提前在类中写好get方法）

在要做数组的遍历或列表的遍历工作时，就要想到用增强for循环，这样效率高且代码简洁。

每次有顾客来得先判断他是否为新顾客，只有新顾客才应该添加进列表，不是新顾客的话，只需在原列表中更改信息即可。

在学习阿里巴巴Java规范手册的时候，学到了很多规范书写的知识，使自己写代码时的思路更清晰了

通过这次学习，我对面向对象的认识更加深刻了，同时，面向csdn的能力提升了不少。

# 判断是否歇业
需要先确定营业时间和歇业时间。假设营业时间为周一至周五的9点到18点，歇业时间为周六、周日以及法定节假日，可以使用LocalDate类进行判断。

首先获取当前日期，判断是否为周六、周日或法定节假日，如果是则歇业；如果不是，则再判断当前时间是否在营业时间范围内，如果是则营业，否则歇业。

以下是示例代码：


    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.time.LocalTime;
    import java.time.Month;
    import java.time.temporal.ChronoUnit;
    
    public class BusinessHoursChecker {
        // 歇业日期列表，包括周六、周日和法定节假日
        private static final LocalDate[] holidays = {
            LocalDate.of(2021, Month.JANUARY, 1), // 元旦
            LocalDate.of(2021, Month.FEBRUARY, 11), // 春节
            LocalDate.of(2021, Month.FEBRUARY, 12), // 春节
            LocalDate.of(2021, Month.FEBRUARY, 13), // 春节
            LocalDate.of(2021, Month.FEBRUARY, 14), // 春节
            LocalDate.of(2021, Month.FEBRUARY, 15), // 春节
            LocalDate.of(2021, Month.FEBRUARY, 16), // 春节
            LocalDate.of(2021, Month.APRIL, 3), // 清明节
            LocalDate.of(2021, Month.APRIL, 4), // 清明节
            LocalDate.of(2021, Month.APRIL, 5), // 清明节
            LocalDate.of(2021, Month.MAY, 1), // 劳动节
            LocalDate.of(2021, Month.MAY, 2), // 劳动节
            LocalDate.of(2021, Month.MAY, 3), // 劳动节
            LocalDate.of(2021, Month.JUNE, 12), // 端午节
            LocalDate.of(2021, Month.JUNE, 13), // 端午节
            LocalDate.of(2021, Month.JUNE, 14), // 端午节
            LocalDate.of(2021, Month.SEPTEMBER, 19), // 中秋节
            LocalDate.of(2021, Month.SEPTEMBER, 20), // 中秋节
            LocalDate.of(2021, Month.SEPTEMBER, 21), // 中秋节
            LocalDate.of(2021, Month.OCTOBER, 1), // 国庆节
            LocalDate.of(2021, Month.OCTOBER, 2), // 国庆节
            LocalDate.of(2021, Month.OCTOBER, 3), // 国庆节
            LocalDate.of(2021, Month.OCTOBER, 4), // 国庆节
            LocalDate.of(2021, Month.OCTOBER, 5), // 国庆节
            LocalDate.of(2021, Month.OCTOBER, 6), // 国庆节
            LocalDate.of(2021, Month.OCTOBER, 7), // 国庆节
        };

    // 营业时间范围
    private static final LocalTime openTime = LocalTime.of(9, 0);
    private static final LocalTime closeTime = LocalTime.of(18, 0);

    public static boolean isBusinessHours() {
        LocalDate today = LocalDate.now();
        if (isHoliday(today)) {
            return false; // 歇业日期
        }
        LocalDateTime now = LocalDateTime.now();
        if (now.toLocalTime().isBefore(openTime) || now.toLocalTime().isAfter(closeTime)) {
            return false; // 非营业时间
        }
        return true;
    }

    private static boolean isHoliday(LocalDate date) {
        for (LocalDate holiday : holidays) {
            if (date.equals(holiday)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("现在是否营业：" + isBusinessHours());
    }
