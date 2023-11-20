# Android Demo

仓库地址：https://github.com/PrinceSaoKe/AndroidDemo

*目前还只是个大概，有些地方代码写的挺乱的*

### 遇到的问题

* RecyclerView移除元素后，由于每个Up主绑定的事件还是原来的position，导致错位
* 使用DataBinding，传入图片的resourceId无法显示图片
* intent传递对象是传递其拷贝而非对象本身，在新的Activity中修改传递的对象无法影响到上个Activity中实例化的对象