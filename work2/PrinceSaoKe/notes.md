# 第二轮考核

简单记一下


## 包管理

修饰符|当前类|同一包内|同一包内的子类|不同包内的子类|其他包
:-:|:-:|:-:|:-:|:-:|:-:
public|√|√|√|√|√
protected|√|√|√|可访问父类的protected，不可访问父类对象的protected|×
default|√|√|√|×|×
private|√|×|×|×|×


## instanceof：判断一个变量是否是某个类的实例

``` java
// Car 是 Vehicle 的子类
Car car = new Car();
boolean flag1 = car instanceof Car      // flag1 = true
boolean flag2 = car instanceof Vehicle  // flag2 = true
boolean flag3 = car instanceof Cat      // flag1 = false
```


## Math

原始值|floor（向下取整）|round（四舍五入）|ceil（向上取整）
:-:|:-:|:-:|:-:
2.7|2|3|3
2.3|2|2|3
-2.3|-3|-2|-2
-2.7|-3|-3|-2

*floor是地板的意思，ceil是天花板，就很好记了*


## throw & throws

throw用于主动抛出异常：

``` java
public double divide(double x, double y) {
    try {
        if (y == 0) {
            throw new ArithmeticException();
        } else {
            return x / y;
        }
    } catch (ArithmeticException exception) {
        exception.printStackTrace();
    }
}
```

加了throws的函数，函数内部抛出的异常要在函数外捕捉到：

``` java
// 当抛出异常时，不在函数内捕捉，而是抛出到函数外
public double divide(double x, double y) throws ArithmeticException {
    if (y == 0) {
        throw new ArithmeticException();
    }
    return x / y;
}

// 捕捉到divide方法内部抛出的异常
public static void main(String[] args) {
    try {
        divide(5, 0);
    } catch (ArithmeticException exception) {
        exception.printStackTrace();
    }
}
```


## ArrayList 与 LinkedList 的区别

### 底层数据结构

* ArrayList 使用动态数组来存储元素，这意味着在内存中分配一块连续的内存空间来保存元素

* LinkedList 使用双向链表来存储元素，每个元素都包含对前一个和后一个元素的引用

### 插入和删除操作

* ArrayList 的随机访问非常快速，因为可以通过索引直接访问元素。但是，插入和删除元素时，需要移动后续元素，效率较低

* LinkedList 的插入和删除操作效率较高，因为只需更改节点的引用。但是，随机访问元素效率较低，因为必须从头或尾部开始遍历链表

### 内存消耗

* ArrayList 在存储大量元素时可能会浪费一些内存，因为它分配一块较大的内存空间。但它在随机访问时效率较高

* LinkedList 每个元素都需要额外的内存来存储引用，因此在存储大量元素时可能会消耗更多内存。但它在插入和删除操作时效率较高

### 适用场景

* ArrayList 适用于需要频繁随机访问元素的情况，但不需要频繁执行插入和删除操作的情况

* LinkedList 适用于需要频繁执行插入和删除操作的情况，但不需要频繁随机访问元素的情况

*chatGPT原话 : )*


## LocalDateTime & LocalDate & LocalTime

*参考的是[这篇文章](https://blog.csdn.net/LiuQQ567/article/details/131269552)*

三者区别是，LocalDate只能存日期，LocalTime只能存时间，LocalDateTime既可以存日期又可以存时间。这里只介绍LocalDateTime。

``` java
// 实例化
var localDateTime1 = LocalDateTime.now();
var localDateTime2 = LocalDateTime.of(2023, 9, 11, 22, 23, 00);     // 2023-09-11 22:23:00

// 字符串转LocalDateTime
var localDateTime3 = LocalDateTime.parse("2023-09-11T22:23:00");    // 必须要有T
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
var localDateTime4 = LocalDateTime.parse("2023-09-11 22:23:00", formatter);     // 将字符串按照formatter中规定的格式转化

// 获取星期
DayOfWeek dayOfWeek = localDateTime1.getDayOfWeek();    // 假设为星期天
System.out.println(dayOfWeek.getValue());   // 7
// TextStyle.FULL(星期全称), Locale.CHINA(用中文输出)
System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.CHINA));     // 星期日
// TextStyle.FULL(星期全称), Locale.CHINA(用中文输出)
System.out.println(dayOfWeek.getDisplayName(TextStyle.Short, Locale.CHINA));    // 周日

// 获取月份同上

// 增加日期
localDateTime1 = localDateTime1.plus(5, ChronoUnit.DAYS);   // 日期+5，下同
localDateTime1 = localDateTime1.plusDays(5);
```


## ~~Date & Calendar~~ （已弃用）

**<h3 style="color: red">注：Date类与Calendar类已弃用！</h3>**

*看完一问chatGPT，才知道这俩已经被LocalDateTime取代了，旧教程害人啊……笔记都做完了，就不删了吧*

按自定义格式输出时间：

``` java
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
System.out.println(format.format(date));
// 2023-09-09 19:54:33 周六
```

其中HH:mm:ss是24小时制，hh:mm:ss是12小时制

或者用printf：

``` java
System.out.printf("现在是：%tY-%tm-%td，%tp%tH:%tM:%tS，%tA", date, date, date, date, date, date, date, date);
// 现在是：2023-09-09，下午20:07:02，星期六
```

使用Calendar

``` java
Calendar calendar = Calendar.getInstance();     // 创建对象，默认为当前时间
calendar.set(2002, 11, 30);                     // 设置年月日
calendar.set(Calendar.YEAR, 2077);              // 单独设置某个属性
System.out.println(calendar.get(Calendar.YEAR));
// 2077
```

*有关Date类与Calendar类的更多信息，参考[这里](https://www.runoob.com/java/java-date-time.html)*