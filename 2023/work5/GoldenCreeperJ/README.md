仓库地址：https://github.com/GoldenCreeperJ/Android_task_5  

不知道子View指的是布局意义上的还是继承意义上的，索性就都写了：  
* 继承子View使用RecyclerView自带的删除动画和基础的运动事件  
* 布局子View使用自定义的删除动画和手势监测类

由于时间太赶，没有两种方法都写，也存在一些小瑕疵：  
* 排版不好导致统计图数据可能看不到
* RecyclerViewItem太小，手势有点难检测到
