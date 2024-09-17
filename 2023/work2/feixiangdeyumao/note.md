# 第二轮考核

简单记录下第二轮考核，估计写不了太多字。

## 任务

开个宠物店，涉及到一些和类相关的知识，大部分见过，但处理异常的部分以前就没学好也没用上过，这次刚好能熟悉一下流程，最后写了个能用的，但找不到动物的异常的一部分在关店后才打印出来，没搞明白为啥是这个顺序。

接口之前课内没接触过，这次粗浅地学了下，感觉和父类子类的继承有点像。不过，一个类可以implement不同的接口，而类之间只能单继承的关系。

做的时候在处理动物性别的变量类型的时候犹豫了下，最后还是先用了String的办法做，如果加个正则表达式应该就能限制性别为Male和Female。另一个选择是用枚举（Enum），这个更加好用但是没学过，周末有时间再去改成枚举类型。

刚做Test类的时候发现还是有很多东西欠缺考虑，比如一个人重复进店，原来的代码会记录两次此人到链表中，所以在测试的时候多搞了一些不一样的例子来测试，也在Test里面注释了

代码规范有接触过一些，但注释标注的部分不在其中。GitHub上的规范打不开，在csdn上找了一份学习。我是在写完代码后才去学规范的，然后对照着改。对于其中“布尔类变量不以is开头”有点不解，看了已经提交的同学的代码，仍用is开头。不过还是老实改了，现在是全改成whether开头了，不知道可读性咋样。注释部分要用javadoc实现，改完后发现确实更加规范，可读了。

## 感想

还好提前开始做了，不然过几天全是DDL又得忙到鸡飞狗跳。。。这次润IDEA了，真的比eclipse好用太多。但还有很多快捷键之类技巧没学完，alr+ctrl+L的规范代码快捷键不知道咋回事用不了，有空去查查。

bonus的部分周末看看有没有时间补上，进程之前在一门课上学过一些，正则表达式大一时也学过，应该不太难做（吧）。

总之这次学到了不少新东西，考核通过的话接下来就是学安卓了。这学期正好有个课要求组队做安卓app，我被安排去搞UI，到时候刚好现学现买了。

没有像其他同学一样写了这么多知识点，实在不会写那样的笔记。

不多写了，学墨刀去了，周五还得交一堆图呢。。。

## 十一月六日补充

把try catch放到主方法里了，注意到如果同一个如果两次进店都出错，只会记录一次到店次数。把每个招待顾客的方法都分别放置到一个单独的try catch里面能够解决，但是这样代码会变得乱七八糟的。。。尝试使用了数组，把顾客和宠物类全部都扔进数组，用for循环依次执行，这样会简洁点，但是不方便做测试和报错的演示，就没有加了，相关的示例代码如下：

```java
// 初始化宠物
Animal[] animals= new Animal[6];

animals[0] = new Dog("大黄", 4, "Male", 200, 100, true);
animals[1] = new Dog("小白", 5, "Female", 200, 100, true);
animals[2] = new Dog("安安", 1, "Female", 300, 50, true);
animals[3] = new Cat("李华", 2, "Male", 200, 100);
animals[4] = new Cat("将军", 6, "Male", 350, 300);
animals[5] = new Lynx("芝士", 8, "Male", 800, 600);

// 初始化顾客
Customer[] customers = new Customer[5];

customers[0] = new Customer("赵二", 0);
customers[1] = new Customer("张三", 0);
customers[2] = new Customer("李四", 1); // 已经来过一次，测试到访次数是否会增加到2
customers[3] = new Customer("王五", 0);
customers[4] = new Customer("老六", 6); // 没来，所以关店后不会被打印出来
```

```java
for(int i = 0; i < customers.length - 1; i ++){
    try{
        myAnimalShop.assistCustomer(customers[i],animals[i]);
    }catch (InsufficientBalanceException e){
        //System.out.println("Caught exception: " + e.getMessage());
        e.printStackTrace(); // 打印异常堆栈跟踪
    }
}
```

同时优化了AnimalNotFountException中的报错信息，现在能显示购买哪个动物的时候出错了。

添加了bonus中的用正则表达式检查邮箱格式的方法。