# 第二轮考核

## abstract 抽象类和方法

- 抽象类不能实例化，由具体的子类实例化
- 抽象方法只需声明，不需实现

|                       抽象类                       |                接口                |
| :------------------------------------------------: | :--------------------------------: |
|          子类使用extend关键字来继承抽象类          | 子类使用关键字implements来实现接口 |
|                    可以有构造器                    |            不能有构造器            |
| 抽象方法可以有public、protected、default这些修饰符 |   默认public,不能使用其他修饰符    |
|                     有main方法                     |             无main方法             |

## LocalDate类

执行日期操作

``` java
LocalDate today = LocalDate.now(); // 获取当前日期
LocalDate specificDate = LocalDate.of(2023, 9, 23); // 创建特定日期，格式为(年, 月, 日)

LocalDate date1 = LocalDate.of(2023, 9, 23);
LocalDate date2 = LocalDate.of(2023, 9, 24);
boolean isBefore = date1.isBefore(date2); // 比较日期1是否在日期2之前
boolean isAfter = date1.isAfter(date2);   // 比较日期1是否在日期2之后
boolean isEqual = date1.isEqual(date2);   // 比较日期1是否等于日期2

LocalDate startDate = LocalDate.of(2023, 9, 20);
LocalDate endDate = LocalDate.of(2023, 9, 30);
long daysBetween = ChronoUnit.DAYS.between(startDate, endDate); // 计算两个日期之间的天数差

LocalDate date = LocalDate.of(2023, 9, 23);
LocalDate plusOneDay = date.plusDays(1);   // 增加一天
LocalDate minusOneWeek = date.minusWeeks(1); // 减少一周
LocalDate firstDayOfMonth = date.withDayOfMonth(1); // 设置日期为当月的第一天

LocalDate date = LocalDate.of(2023, 9, 23);
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
String formattedDate = date.format(formatter); // 将日期格式化为字符串
```

- 遇到`Result of 'LocalDate.plusDays()' is ignored`警告：调用类似 `plusDays()` 的方法时没有将结果分配给任何变量或以任何方式使用它。

## 正则表达式

> http://t.csdnimg.cn/KToA6

## 多线程

Java 提供了三种创建线程的方法：

- 通过实现 Runnable 接口；
- 通过继承 Thread 类本身；
- 通过 Callable 和 Future 创建线程。

> 参考https://www.runoob.com/java/java-multithreading.html