# Java & Android第一轮考核

## 参考资料

### 参考视频（建议刚接触编程语言的跟着视频走）

* [狂神说Java]( https://www.bilibili.com/video/BV12J41137hu?share_source=copy_web&vd_source=7d2fd3963c594f890889ebd454ef8d1c)	(通俗易懂，学习方法也讲的不错，后面也有一些内容是推荐狂神老师的视频教程)
* [黑马程序员Java零基础视频教程](https://www.bilibili.com/video/BV17F411T7Ao?vd_source=e7a1a430689d9d09f914db65fcdea382)
* [动力节点](https://www.bilibili.com/video/BV1Rx411876f?share_source=copy_web&vd_source=7d2fd3963c594f890889ebd454ef8d1c)
* Android Kotlin：
    * [Kotlin 基础视频+文章 by 扔物线](https://rengwuxian.com/kotlin-basic-1/)
    * [Kotlin 从入门到实战](https://www.bilibili.com/video/BV1bZ4y1N7my)

### 基础参考教程

* [廖雪峰Java入门教程 (liaoxuefeng.com)](https://www.liaoxuefeng.com/wiki/1252599548343744) **不建议跟着用Eclipse，关于IDE的推荐具体看下面的提示**
* [编程狮](https://www.w3cschool.cn/java/)

### 推荐书籍

* 《Head First Java》(图解多、讲的比较简单、内容不够全面，可以来读读提高兴趣)
* 《Java核心技术卷Ⅰ》
* 《Java核心技术卷Ⅱ》
* 《Thinking In Java》 (人称Java圣经(可能会有些难懂))
* 对 Android 方向，可以提前通过以下资料熟悉下 Kotlin：
    * [Java to Kotlin](https://github.com/MindorksOpenSource/from-java-to-kotlin)
    * [Kotlin 官方指南](https://www.kotlincn.net/docs/reference/basic-syntax.html)



## 知识点

* 配置编译环境
* 输入输出
* 选择结构、循环结构
* 方法
* 数组

* 封装、继承、抽象、多态、接口
* 异常处理
* 集合
* 泛型

* Bonus
    * java.uitl以及java.math下的一些常用工具类 (如 Date / Math / Random / BigDemical / ArrayList 等等等等)
    * 多线程 (JUC)
    * 正则表达式

## 任务

* 进行Java开发环境配置
* 完成下面两项在线刷题网站的任务，当然写的越多越好，尽可能的熟悉java语言
    * 进行[基础编程题目集 (pintia.cn)](https://pintia.cn/problem-sets/14/exam/problems/type/7)练习，并达到至少一百分
    * 完成[27. 移除元素 - 力扣（LeetCode）](https://leetcode.cn/problems/remove-element/)
> 注意：提交你的分数的截图或者可以其他证明你已经完成的截图
* 宠物店

> 用代码来写一个自己的宠物店，题目有点长耐心看~
> 完成下面的类
>
> **开一家宠物店，宠物店要有动物还要有顾客**

**【强制】注意编程规范**
[阿里巴巴开发规范](https://github.com/west2-online/learn-java/blob/main/etc/blog/阿里巴巴Java开发手册.pdf)

**1. 一个Animal动物类 (抽象类 abstract )**

* 变量:
    * 动物名(String)
    * 年龄(int)
    * 性别
    * 价格(double)
    * ....
* 方法
    * 一个全参构造方法
    * 一个抽象的toString() 方法
    * ........

**2. 中华田园犬类** (extends Animal)<img src="https://gitee.com/sky-dog/note/raw/master/img/202210252201019.jpg" alt="img" style="zoom:3%;" />

* 变量: isVaccineInjected(boolean 是否注射狂犬病疫苗)
* 价格100元

**3. 猫猫类 (extends Animal)**<img src="https://gitee.com/sky-dog/note/raw/master/img/202210252202619.png" alt="image-20221025220229577" style="zoom:15%;" />

* 价格200元

**4. 你喜欢的其他动物.....**<img src="https://gitee.com/sky-dog/note/raw/master/img/202210252202563.png" alt="image-20221025220257537" style="zoom:50%;" />

* 自由选择 合理就行

**5. 顾客类Customer**

* 成员变量:
    * 顾客名字(String)
    * 到店次数(int)
    * 最新到店时间(LocalDate类)
* 方法
    * 重写(@Override) toString() 方法, 要求按一定格式输出客户的所有信息

**6. 宠物店接口AnimalShop(interface)**

你的宠物店需要有一些基础功能:

* 买入新动物(需要的参数自己决定)
* 招待客户(Customer)
* 歇业()

**7. MyAnimalShop自己的宠物店 (implements AnimalShop)**

* 变量:

    * 店的余额double
    * 一个存放动物的列表 (使用ArrayList、LinkedList或其他你喜欢的List实现)
    * 一个顾客列表留作纪念
    * 是否正在营业
    * ....

* 实现接口中的方法

    * 买入动物 -> 买入一只动物，记得在动物列表中添加，

      如余额不足则抛出异常InsufficientBalanceException

    * 招待客户 -> 接受客户参数，在顾客列表中加入新顾客，

      出售动物，如果店内没有动物，抛出AnimalNotFoundException。

      通过toString输出动物信息，并把钱入账，将动物移除列表

    * 歇业 -> (LocalDate判断) 输出当天光顾的客户的列表信息，计算并输出一天的利润

**8. 自定义异常类**

* 异常类 (AnimalNotFountException) 没找到动物异常，店内没有动物可买时抛出
* 异常类 (InsufficientBalanceException) 余额不足异常时抛出
* 两个异常类均继承自RunTimeException, 异常中需要携带错误信息，方便捕获后处理和查看

**9. 一个Test类, 用于测试你写的类功能是否正常**

* 创建一个宠物店实例，给定余额，初始化动物列表，一个空的顾客列表
* 测试买入动物，招待顾客，歇业
* 建议多拿点例子测试，发现bug可以马上改，多考虑代码严谨性



## Bonus

* 设计两个方法

    * 设计一个接收两个int数组的方法void, 使用多线程交替输出其中的元素
        * 如接收 arr1 = {1, 3, 5, 7, 9}, arr2 = {2, 4, 6, 8, 10}, 则输出 1 2 3 4 5 6 7 8 9 10
    * 设计一个接收邮箱String的方法boolean, 使用正则表达式或其他方法判断邮箱格式是否合法

## 



## 提示

* 学习资料择需学习即可，不需要全部学习

* [ Java环境简单配置+IDEA](https://blog.csdn.net/qq_33215972/article/details/73693140)

* 强烈建议使用[IntelliJ IDEA](https://www.jetbrains.com/zh-cn/idea/)进行编程

    * IntelliJ Idea(之后简称Idea)可以通过[福州大学邮件系统 (fzu.edu.cn)](https://fzu.edu.cn/coremail/index.jsp)进行[Idea学生认证](https://www.jetbrains.com/shop/eform/students/)后可免费使用一年(到期再次申请即可)
    * [2022 JetBrains 开发工具——学生授权免费申请指南 | Company Blog](https://blog.jetbrains.com/zh-hans/blog/2022/08/24/2022-jetbrains-student-program/)

* 参数名请使用有意义的单词或短语，要求**见名知意**

* 构造函数与get/set等自行斟酌
* Bonus不做强制要求
* 抽象类的成员变量均为protected
* 部分变量选择尽量符合实际
* 注意命名规范，使用驼峰命名法
* 注意代码格式规范，可使用Idea自带的格式化快捷键 *ctrl+alt+L* 进行代码格式化
* Test类的实现可用正则Regex或其他方法，写完后可在第一题中的main方法中测试功能是否正确
* 除了面向对象，希望大家也能有面向 google/github/必应/csdn/博客园/百度 学习的能力
* 如果有实在写不完或者不理解的部分，可以加一些注释写一点思路或者想法 (可以用`//TODO`来标记未完成的部分)

* 大家刚开始写都会有些懵懵的，不知道在写啥，不过这次只要能写出来能跑就行了，不懂的以后会慢慢再接触了解的。

