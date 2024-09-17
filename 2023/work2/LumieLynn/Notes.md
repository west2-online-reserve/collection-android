碎记
# Final Finally Finalize 三者的区别

* 1. final修饰的类不能被继承，修饰的方法不能被重写，修饰的变量变常量  

* 2. finally是try catch语句的一部分，表示要最终执行的代码，常用来做资源的释放  

* 3. finalize: Object中的方法，在垃圾回收时会用到的放法

# throw 与 throws 的区别

* 1. throws用在方法名后面，跟的是异常类名。throw是用在方法体内，跟的异常对象  

* 2. throws可以跟多个异常类名，用逗号隔开。throw只能抛出一个异常对象  

* 3. throws表示抛出异常，由该方法调用者处理。throw表示抛出异常由方法体内的语句处理  

* 4. throws表示出现异常的一种可能性，并不一定发生；throw则是抛出了异常，执行throw真实的产生了Exception对象

# 基本数据类型对应的包装类

* byte --> Byte  
* short --> Short  
* char --> Character  
* int --> Integer  
* long --> Long  
* float --> Float  
* double --> Double  
* boolean --> Boolean

# ArrayList 与 LinkedList 的区别
在Java中，ArrayList和LinkedList都是用来存储数据的集合，但它们在内部实现、性能和用途上有一些区别。

1. 内部实现：ArrayList基于动态数组实现，而LinkedList基于双向链表实现。
    
2. 性能：
    - 随机访问：由于ArrayList基于数组实现，所以获取指定索引位置的元素（get和set操作）非常快，时间复杂度为O(1)。而LinkedList需要遍历链表直到找到指定索引的元素，所以访问性能较差，时间复杂度为O(n)。
    - 插入和删除：在列表的前端或后端插入或删除元素时，LinkedList具有较好的性能，因为它的头尾插入和删除操作时间复杂度为O(1)。而ArrayList的插入和删除操作需要移动元素，所以性能较差，时间复杂度为O(n)。
3. 用途：
    - 如果需要频繁地访问元素，那么ArrayList是一个更好的选择，因为它可以快速地访问元素。
    - 如果需要频繁地在列表的前端或后端插入或删除元素，那么LinkedList是一个更好的选择，因为它可以快速地执行这些操作。