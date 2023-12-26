# Android Demo

仓库地址：https://github.com/PrinceSaoKe/AndroidDemo
APK下载链接：https://github.com/PrinceSaoKe/AndroidDemo/releases/download/work3/app-release.apk

### 遇到的问题

* ~~RecyclerView移除元素后，由于每个Up主绑定的事件还是原来的position，导致错位~~（已解决，用notifyItemRangeChanged） [Recyclerview 局部刷新](https://blog.csdn.net/dianzi314779725/article/details/99829585)
* 使用DataBinding，传入图片的resourceId无法显示图片，只好用ViewBinding
* intent无法传递对象，用序列化等方法似乎是传递其拷贝而非对象本身，在新的Activity中修改传递的对象无法影响到上个Activity中实例化的对象（还没自己去试过）
* OnBackPressed被弃用，改用onBackPressedDispatcher [第一行代码（第3版）弃用方法汇总](https://zhuanlan.zhihu.com/p/625972098)