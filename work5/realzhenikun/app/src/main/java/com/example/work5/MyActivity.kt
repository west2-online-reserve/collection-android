package com.example.work5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.sp
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox


class MyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var demo = mutableListOf<DemoData>()
            demo.add(DemoData(1, "123"))
            demo.add(DemoData(2, "ABC"))
            demo.add(DemoData(3, "！@#"))
            demo.add(DemoData(4, "自行车"))
            SwipeDemo(demo)
        }
    }
}

data class DemoData(val id: Int, val title: String)

//使用swipe库，实现滑动删除
@Composable
fun SwipeDemo(list: MutableList<DemoData>) {
    val data = remember {
        mutableStateListOf<DemoData>()
    }
    data.addAll(list)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
    ) {
        itemsIndexed(data, key = { index, item -> item.id }) { index, item ->
            val delete = SwipeAction(
                icon = {
                    //设置删除图标
                    Icon(
                        Icons.Default.Delete,
                        contentDescription = "",
                        modifier = Modifier
                    )
                },
                background = Color.Red,
                onSwipe = { data.remove(data.find { it.id == item.id }) }
            )
            SwipeableActionsBox( //设置滑动动作
                startActions = listOf(delete),
                endActions = listOf(delete), //左右滑动均为删除
                swipeThreshold = 80.dp,
                backgroundUntilSwipeThreshold = Color.LightGray //未达到阈值时显示为灰色
            ) {
                Box(
                    Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(Color.White),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(item.title)
                }
            }
        }
    }
}
