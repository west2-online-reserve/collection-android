# 一、代码仓库地址

[HeXioahei/ImitateBili: 这是西二android第三轮考核的作业 (github.com)](https://github.com/HeXioahei/ImitateBili)

# 

# 二、环境要求

![](file:///C:/Users/HUAWEI/Pictures/Screenshots/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202023-12-22%20002020.png)

![](file:///C:/Users/HUAWEI/Pictures/Screenshots/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202023-12-22%20002044.png)

（代码中有个方法要求API至少为33，故minSdk=33）





# 三、学习笔记

## 1.fragment

ScaleFragment ：缩放

RotateFragment：旋转

TranslateFragment：平移

## 2.如何直接将安卓项目从as上传到github

[Android Studio上传Android项目到GitHub（最新）-CSDN博客](https://blog.csdn.net/HHHceo/article/details/117194834?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522170316711616800192224793%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=170316711616800192224793&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-2-117194834-null-null.142^v96^pc_search_result_base1&utm_term=%E5%A6%82%E4%BD%95%E5%B0%86AndroidStudio%E7%9A%84%E9%A1%B9%E7%9B%AE%E7%9B%B4%E6%8E%A5%E4%B8%8A%E4%BC%A0%E5%88%B0%E8%87%AA%E5%B7%B1%E7%9A%84github%E4%BB%93%E5%BA%93%E9%87%8C&spm=1018.2226.3001.4187)

## 3.如何生成apk文件

https://blog.csdn.net/yushuangping/article/details/83094605

## 4.项目结构规范

[Android开发规范：包命名规范_android项目中的各个包的命名-CSDN博客](https://blog.csdn.net/ddnosh/article/details/100658274?spm=1001.2014.3001.5506)

## 4.安卓开发规范

[Android开发规范（自用简单版）_android 开发规范-CSDN博客](https://blog.csdn.net/musiclife123/article/details/126485194?spm=1001.2014.3001.5506)

## 5.如何安装AS并配置好环境

[Android Studio详细安装教程_android安装教程-CSDN博客](https://blog.csdn.net/qq_53039581/article/details/124789047)

（AS会占用很大的储存空间，可以把它装在D盘，那在安装的过程中，要十分小心注意那些选择目录选择路径的地方，不要点错，点错就得重来）

## 6.安卓开发工具

安卓开发比较庞大，需要用到**JDK、AndroidSDK、AS、Gradle**等很多工具。前两个用来提供各种工具类来帮助我们开发，最后一个可以从外源库引入很多的依赖。sdk版本决定api版本，影响着方法的调用以及程序能否正常安装与运行。他们的作用很大，我还有很多不了解的地方。



## 7.viewBinding

##### （1）别人的博客（Java版）

[废弃的kotlin-android-extensions，是时候接受ViewBinding了_androidextensions-CSDN博客](https://blog.csdn.net/Goals1989/article/details/126876290?spm=1001.2014.3001.5506)

##### （2）AI的解答（kotlin版）

View Binding 是一个在 Android 中简化视图引用的特性。它允许你直接通过类名来引用视图，而不是使用 `findViewById` 函数。在 Adapter 中使用 View Binding 可以简化代码，提高可读性。

以下是一个使用 Kotlin 语言在 Adapter 中使用 View Binding 的示例：

1. 首先，确保你的项目启用了 View Binding。在 `build.gradle` 文件中添加以下配置：
    android {
   
        ...
        viewBinding {
            enabled = true
        }
   
    }

2. 在 Activity 或 Fragment 中，将视图布局与视图绑定类关联起来。例如，假设你的布局文件名为 `activity_main.xml`，则创建一个名为 `MainActivityBinding` 的类：
    class MainActivityBinding : ViewDataBinding {
   
        private lateinit var mainViewModel: MainViewModel
       
        fun setMainViewModel(mainViewModel: MainViewModel) {
            this.mainViewModel = mainViewModel
            mainViewModel.loadData() // 假设有一个加载数据的函数
        }
   
    }

3. 在 Activity 或 Fragment 中，使用 `binding` 对象来引用布局中的视图：
    class MainActivity : AppCompatActivity() {
   
        private lateinit var binding: MainActivityBinding
        private lateinit var mainViewModel: MainViewModel
       
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = MainActivityBinding.inflate(layoutInflater)
            setContentView(binding.root)
            mainViewModel = viewModel() // 假设有一个获取 ViewModel 的函数
            binding.setMainViewModel(mainViewModel)
        }
   
    }

4. 在 Adapter 中，使用 View Binding 来引用视图。例如，假设 Adapter 类名为 `MainAdapter`：
    class MainAdapter(private val mainViewModel: MainViewModel) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
   
        class ViewHolder(val binding: MainActivityBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(item: Item) {
                binding.textView.text = item.text // 直接引用视图，无需使用 findViewById 函数
            }
        }
       
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = MainActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(view)
        }
       
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = mainViewModel.items[position] // 假设有一个获取数据的函数，这里简单地假设了 items 是 MainViewModel 的一个属性，实际应用中可能是从数据库或其他来源获取的列表数据。
            holder.bind(item) // 在 ViewHolder 中绑定数据到视图上。注意这里是在 ViewHolder 的内部方法中绑定的。如果直接在 Adapter 中使用，会导致数据重复绑定。
        }
   
    }

在这个示例中，`MainActivityBinding` 绑定到了布局中的视图，并在 Activity 中通过 `binding.textView` 等方式直接引用。在 Adapter 中，通过创建 `ViewHolder` 类并使用 View Binding 来引用视图，从而简化了代码并提高了可读性。

##### （3）我的一些实践与总结

[kotlin - ViewBinding-CSDN博客](https://blog.csdn.net/hxh_230810/article/details/134915401?spm=1001.2014.3001.5502)



## 8.Activity

### （1）Toast

需要一个触发点，一般是点击事件。
    button.setOnClickListener {
        Toast.makeText(this, "/*文本*/", Toast.LENGTH_SHORT).show()
    }

### （2）Menu

### （3）Intent

* 用于Activity之间的穿梭，分为显式和隐式，前者可以直接通过参数指明下一个Activity，后者通过一些信息的匹配以及AndroidMainfest.xml中相应标签的设置来进行Activity的切换

* 可以传递信息给下一个Activity，也可以返回数据给上一个Activity，后者需用到startActivityForResult()。返回时要finish()当前Activity。用putExtra()来传递信息，getExtra()获取信息。

* 可以结合conpanion object来达到启动Activity的最佳方法（object：单例类）

### （4）Activity的生命周期

##### 1）四个状态

* 运行：在栈顶

* 暂停：不在栈顶，存活可见，但不可互动操作

* 停止：不在栈顶，不可见，更不可操作

* 销毁：不在栈中

##### 2）生存期

* 完整生存期：onCreate()->onDestroy()

* 可见生存期：onStart()->onStop()

* 前台生存期：onResume()->onPause()

##### 3）启动模式

* standard

* singleTop

* singleTask

* singleInstance





## 9.控件和布局

### （1）我的博客我的笔记（没想到竟然还有不少人收藏）

[Android布局控件之LinearLayout、RelativeLayout、GridLayout、ScrollView-CSDN博客](https://blog.csdn.net/hxh_230810/article/details/134753009?spm=1001.2014.3001.5502)

[Button初了解-CSDN博客](https://blog.csdn.net/hxh_230810/article/details/134766391?spm=1001.2014.3001.5502)

[Botton进一步了解（点击事件）-CSDN博客](https://blog.csdn.net/hxh_230810/article/details/134907738?spm=1001.2014.3001.5502)

### （2）scaleType

ScaleType是用于控制图片在ImageView中如何进行缩放的属性。它的主要作用是控制ImageView中显示的图片的大小。

以下是几种常见的ScaleType：

1. `matrix`：保持原图大小，从左上角的点开始，以矩阵形式绘图。
2. `fitXY`：将原图进行横方向（即XY方向）的拉伸后绘制。
3. `fitStart`：将原图沿左上角的点（即matrix方式绘图开始的点），按比例缩放原图绘制而成。
4. `fitCenter`：将原图沿上方居中的点（即matrix方式绘图第一行的居中的点），按比例缩放原图绘制而成。
5. `fitEnd`：将原图沿下方居中的点（即matrix方式绘图最后一行的居中的点），按比例缩放原图绘制而成。
6. `Center`：保持原图大小，以原图的几何中心点和ImagView的几何中心点为基准，只绘制ImagView大小的图像。
7. `centerCrop`：不保持原图大小，以原图的几何中心点和ImagView的几何中心点为基准，只绘制ImagView大小的图像（以填满ImagView为目标，对原图进行裁剪）。
8. `centerInside`：不保持原图大小，以原图的几何中心点和ImagView的几何中心点为基准，只绘制ImagView大小的图像（以显示完整图片为目标，对原图进行缩放）。

### （3）recyclerView

[RecyclerView性能优化及高级使用_ondetachedfromrecyclerview-CSDN博客](https://blog.csdn.net/suyimin2010/article/details/106870380/?spm=1001.2014.3001.5506)

（这次作业中，这篇博客中的局部刷新方法给了我不少启发）

* 需要适配器，以及布局管理器来管理它的界面

### （4）viewPager2

* 需要适配器

* 可以和Fragment结合使用

### （5）viewPager2与recyclerView的结合

    // recyclerView的当前项随着viewPager2的当前页变化
            binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    binding.recyclerView.scrollToPosition(position)
                }
            })
    
    viewHolder.bloggerHeadImage.setOnClickListener {
                viewPager2.currentItem = viewHolder.bindingAdapterPosition   // viewPager2 的当前页随 recyclerView 的当前项变化
            }



## 10.对于kotlin一些代码语法的分析与理解

### （1）.

    holder.itemView.setOnClickListener {
        onItemClickListener?.let { listener ->
            listener(position)
        }
    }

1. **holder.itemView.setOnClickListener { ... }**

这行代码是为`holder.itemView`设置一个点击监听器。当这个`itemView`被点击时，会执行大括号 `{ ... }` 里面的代码。2. **onItemClickListener?**

这里使用了Kotlin的安全调用运算符（`?.`）。它会在`onItemClickListener`不为null的情况下执行后面的操作，如果为null则不执行。这有助于避免空指针异常。3. **let { listener -> ... }**

`let`是Kotlin中的一个扩展函数，它允许你在一个对象的上下文中执行一个lambda表达式。这里，`let`函数接收一个lambda表达式作为参数，并将`onItemClickListener`作为参数传递给这个lambda表达式。在这个lambda表达式中，你可以通过参数名`listener`来引用`onItemClickListener`。4. **listener(position)**

这行代码调用了`listener`函数，并将`position`作为参数传递给它。这里假设`listener`是一个接受一个参数（即item的位置）的函数。当`itemView`被点击时，这行代码将会执行，从而调用`onItemClickListener`函数，并将被点击的item的位置传递给它。

综上所述，这段代码的主要作用是：当某个item被点击时，如果设置了`onItemClickListener`，则会调用这个函数，并将被点击的item的位置作为参数传递给它。如果没有设置`onItemClickListener`（即为null），则不会执行任何操作。这种设计方式可以避免空指针异常，并使得代码更加简洁和安全。

### （2）.

    val view = LayoutInflater.from(parent.context).inflate(R.layout.blogger_item, parent, false)

您提供的代码片段是用于在Android中通过`LayoutInflater`从XML布局文件中创建视图（View）的。
    val view = LayoutInflater.from(parent.context).inflate(R.layout.blogger_item, parent, false)

这里是该代码片段的简单解释：

1. `LayoutInflater.from(parent.context)`: 这会返回一个`LayoutInflater`对象，该对象用于将XML布局文件转换为视图。
2. `inflate(R.layout.blogger_item, parent, false)`: 这是`inflate`方法，它有三个参数：
   * `R.layout.blogger_item`: 这是要加载的XML布局文件的资源ID。
   * `parent`: 这是父视图，其中要插入新视图的位置。注意，在这里我们不是真的要将其插入到父视图中，因为第三个参数是`false`。
   * `false`: 这表示我们不希望将新视图附加到父视图。

返回的`view`是一个新的视图，它代表了`blogger_item`布局。您可以在此基础上进行进一步的配置或操作。

如果您的代码中有任何问题或您需要进一步的帮助，请告诉我！



## 11.其他零碎问题

##### （1）如何通过Activity中的代码在布局中的ImagineView中添加图像

    imageView.setImageResource(R.drawable.your_image)

##### （2）如何通过Activity中的代码在布局中添加数据

    textView.text = "这是通过代码添加的数据！"  

##### （3）怎么样设置button里文字的大小

要设置按钮（Button）中文字的大小，你可以使用以下两种方法：

1. 通过XML样式设置：在布局文件中，为按钮设置一个样式，然后在样式中设置文字的大小。例如，在`styles.xml`文件中添加以下样式：
   
   <style name="ButtonTextSize" parent="Widget.AppCompat.Button">
        <item name="android:textSize">16sp</item>
    </style>

然后在布局文件中，将按钮的样式设置为`ButtonTextSize`：
    <Button
        android:id="@+id/my_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        style="@style/ButtonTextSize"
        android:text="点击我" />

这将使按钮中的文字大小为16sp。你可以根据需要调整`<item name="android:textSize">`中的值。2. 通过代码设置：如果你需要在Activity的代码中动态设置按钮中的文字大小，你可以使用`setTextSize()`方法。例如：
    val button = findViewById<Button>(R.id.my_button)
    button.setTextSize(16f) // 设置文字大小为16sp

这将使按钮中的文字大小为16sp。你可以根据需要调整`setTextSize()`中的值。

以上两种方法都可以设置按钮中的文字大小，你可以根据具体需求选择适合的方法。

##### （4）viewPager2没有布局管理器吗

ViewPager2没有内置的布局管理器。ViewPager2是一个简单的滑动视图组件，它允许用户在多个页面之间进行左右滑动切换。但是，它并没有内置的布局管理器来管理这些页面。

为了使用ViewPager2，你需要自己实现一个适配器来管理页面。适配器通常是一个继承自RecyclerView.Adapter的类，它负责生成每个页面的视图，并将数据绑定到这些视图上。

在适配器中，你需要重写`onCreateViewHolder`和`onBindViewHolder`方法。`onCreateViewHolder`方法用于创建每个页面的视图，而`onBindViewHolder`方法用于将数据绑定到每个页面的视图上。

你可以根据需要自定义适配器，例如使用FragmentPagerAdapter或FragmentStatePagerAdapter等标准适配器，它们可以更方便地与Fragment结合使用。

总之，虽然ViewPager2没有内置的布局管理器，但你可以通过实现适配器来管理页面，从而实现左右滑动切换的效果。

##### （5）inflate()

`inflate()` 是一个常用于 Android 开发中的方法，它通常与 `LayoutInflater` 类一起使用。这个方法的主要作用是将一个 XML 布局文件转换为一个视图（View）对象。

在 Android 中，你可以在 XML 文件中定义界面布局，然后在代码中动态地加载和显示这些布局。`inflate()` 方法就是用来实现这一动态加载过程的。

使用 `inflate()` 方法的基本步骤如下：

1. 首先，你需要获取一个 `LayoutInflater` 实例。通常，你可以通过 `getLayoutInflater()` 方法从当前的 `Activity` 或 `Fragment` 中获取这个实例。

2. 使用 `inflate()` 方法，你可以指定要加载的布局文件的资源 ID。例如：
    val layoutInflater = activity.layoutInflater
    val view = layoutInflater.inflate(R.layout.my_layout, null)

这里，`R.layout.my_layout` 是你要加载的布局文件的资源 ID。3. 你还可以传递一个 `ViewGroup` 参数作为 `inflate()` 方法的第二个参数。这个参数表示要将加载的布局文件附加到的父视图。如果传递 `null`，那么加载的视图将没有父视图。4. `inflate()` 方法返回一个视图对象，你可以对这个对象进行进一步的操作，例如设置其属性、添加事件监听器等。

使用 `inflate()` 方法可以方便地动态加载和修改界面布局，使得 Android 开发更加灵活和高效。

inflate方法的使用通常与LayoutInflater类一起使用，用于将XML布局文件转换为视图对象。

以下是inflate方法的基本用法：

1. 获取LayoutInflater实例：首先，你需要从当前Activity或Fragment中获取LayoutInflater实例。这可以通过调用`getLayoutInflater()`方法来实现。
2. 指定要加载的布局文件：使用inflate方法的第一个参数指定要加载的布局文件的资源ID。例如，`inflate(R.layout.my_layout, null)`将加载名为`my_layout`的布局文件。
3. 指定附加的父视图：inflate方法的第二个参数是一个可选的参数，用于指定要将加载的布局文件附加到的父视图。如果传递null，加载的视图将没有父视图。
4. 返回视图对象：inflate方法返回一个视图对象，你可以对这个对象进行进一步的操作，例如设置其属性、添加事件监听器等。

下面是一个示例代码，演示了如何使用inflate方法加载布局文件：
    // 获取LayoutInflater实例
    LayoutInflater inflater = getLayoutInflater();
    // 指定要加载的布局文件
    View view = inflater.inflate(R.layout.my_layout, null);

    // 对视图进行进一步操作
    // ...

请注意，inflate方法的使用可能会因上下文而有所不同，具体用法可能会因开发者的需求和情况而有所不同。上述示例代码仅为演示基本用法，实际应用中可能需要根据具体情况进行适当的调整和扩展。

##### （6）若在将binding声明为类变量，他就打不开Activity，若放在局部方法中，其他方法就无法调用，怎么办

如果在将Binding声明为类变量时无法打开Activity，而在局部方法中其他方法无法调用，这可能是由于Binding对象的作用域问题导致的。

Binding对象是在编译时生成的，并且它的生命周期与Activity的生命周期是紧密相关的。因此，将Binding对象声明为类变量时，它可能无法正确地与Activity关联。而在局部方法中声明Binding对象时，其他方法无法访问该对象，因为它是局部的。

为了解决这个问题，你可以考虑将Binding对象作为Activity的成员变量，并在Activity的构造函数或初始化方法中创建和初始化它。这样，Binding对象就可以正确地与Activity关联，并且可以在Activity的任何方法中访问它。

以下是一个示例代码片段，演示了如何在Activity中创建和初始化Binding对象：
    class MyActivity : AppCompatActivity() {
        private lateinit var binding: ActivityMyActivityBinding // 声明Binding对象为成员变量
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMyActivityBinding.inflate(layoutInflater) // 在onCreate方法中创建和初始化Binding对象
            val view = binding.root
            setContentView(view)
            // 在这里可以使用binding对象，例如binding.textView.text = "Hello"
        }
    }

在上面的示例中，Binding对象被声明为`ActivityMyActivityBinding`类型，并在`onCreate`方法中使用`inflate`方法创建和初始化。然后，将根视图赋值给`view`变量，并通过`setContentView`方法将其设置为Activity的内容视图。现在，你可以在Activity的其他任何方法中使用`binding`对象，而不会出现作用域问题。

##### （6）kotlin中要判断两个对象是否数据相等，可以直接用“==”号吗

在 Kotlin 中，判断两个对象是否数据相等通常使用 `equals()` 方法，而不是直接使用 `==` 符号。`==` 用于判断两个对象引用是否相同，即它们是否指向内存中的同一个对象实例。而 `equals()` 方法用于比较两个对象的内容是否相等。

##### （7）kotlin如何将string.xml文件中定义的字符串进行引用和输出

    val myString = resources.getString(R.string.my_string)  

（resources包只有Activity类才能调用，普通类想调用，必须有个Activity实例对象来调用）

##### （8）parcelable用kotlin怎么用

Parcelable是Android中的一个接口，它使得对象可以轻松地在应用组件之间传递。在Kotlin中，你可以通过实现Parcelable接口来创建一个可序列化的对象。以下是一个简单的示例：
    class Person : Parcelable {
        var name: String = ""
        var age: Int = 0
        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(name)
            parcel.writeInt(age)
        }

        constructor(parcel: Parcel) {
            name = parcel.readString()
            age = parcel.readInt()
        }

        companion object {
            @JvmStatic fun CREATOR : Parcelable.Creator<Person> = object : Parcelable.Creator<Person> {
                override fun createFromParcel(parcel: Parcel): Person = Person(parcel)
                override fun newArray(size: Int): Array<Person?> = arrayOfNulls(size)
            }
        }
    }

在这个示例中，我们创建了一个名为Person的类，并实现了Parcelable接口。在writeToParcel方法中，我们将对象的属性写入到Parcel对象中。在构造函数中，我们从Parcel对象中读取属性。我们还提供了一个CREATOR对象，它实现了Parcelable.Creator接口，用于创建Person对象和从Parcel对象中读取Person对象。

现在，你可以使用Person类来创建一个可序列化的对象，并将其传递给其他组件：
    val person = Person("John", 30)
    val intent = Intent()
    intent.putExtra("person", person)
    startActivity(intent)

在目标组件中，你可以从Intent中获取Person对象：
    val person = intent.getParcelableExtra("person") as Person
    println(person.name) // 输出 "John"
    println(person.age) // 输出 30



## 12.学习资源

* 书籍：《第一行代码》

* 视频课：
  
  * up主：动脑学院，不过他用的是java，而我用kotlin，所以有些地方学起来比较费劲
  
  * up主：longway777（主要通过他的视频了解了viewPager2以及一些些的Fragment）

* AI：文心一言（遇到具体的零碎的问题时，一般找他解决）

* 学长：[doge]我最后的秘密武器，有求必应，帮我在最困难的时刻度过难关。[doge]
  
  
  
  
  
  

# 四、进步

* 自学能力、解决问题的能力、分析代码的能力提升了

* 了解了不少Android开发相关常识

* 更加有勇气问学长问题，以前一直怕问问题会占用学长很多时间，而学长每次都会给我解答

* 做出第一个可以在手机上运行的小小小项目，虽然很简陋、很普通，但在手机上成功运行的那一刻，滑着屏幕，测试着功能，分享给同学安装，内心真的很喜悦，还是很有成就感的

* 更加坚定，学习技术，加入西二，学习技术，已经坚持快一半了，继续加油
  
  
  
  

# 五、缺陷与不足

* 基础不够扎实，知识较为零碎，不成体系，Java的知识有遗漏，关于泛型、lambda、接口、API还是较为模糊

* 新学kotlin，感觉代码变简洁了很多，但是理解起来有点费劲，语法还没有记熟，需要翻书和依靠编译器的代码提示

* 这次感觉有点依赖AI了，AI帮了我了挺大忙的

* 项目中没有突出之处
