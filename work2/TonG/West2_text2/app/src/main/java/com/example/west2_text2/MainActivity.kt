package com.example.west2_text2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.west2_text2.data.domain.model.UpsList
import com.example.west2_text2.data.local.myUps
import com.example.west2_text2.screens.Detail
import com.example.west2_text2.ui.theme.West2_text2Theme
import com.example.west2_text2.ui.theme.all_horizonalPadding
import com.example.west2_text2.ui.theme.all_roundClip
import com.example.west2_text2.ui.theme.all_verticalPadding
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            West2_text2Theme {
                MainBody()
            }
        }
    }
}



@Composable
fun MainBody() {
    var currentID by remember { mutableIntStateOf(1) }


    val currentIndex = remember(currentID) {
        myUps.indexOfFirst { it.ID == currentID }.takeIf { it != -1 } ?: 0
    }

    val lazyListState = rememberLazyListState()
    val topLazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(currentIndex) {
        lazyListState.animateScrollToItem(index = currentIndex)
    }

    val maxValidIndex = remember { myUps.size - 1 }


    LaunchedEffect(Unit) {
        snapshotFlow { lazyListState.isScrollInProgress }
            .distinctUntilChanged()
            .filter { !it }
            .collect {
                val firstItem = lazyListState.layoutInfo.visibleItemsInfo.firstOrNull() ?: return@collect
                val localCurrentIndex = firstItem.index
                val itemWidth = firstItem.size.toFloat()
                val offset = firstItem.offset.toFloat()

                // 新最小滚动距离过滤（仅当偏移量绝对值大于Item宽度的10%，才执行后续逻辑）
                val minScrollThreshold = itemWidth * 0.1f
                if (kotlin.math.abs(offset) < minScrollThreshold) {
                    return@collect // 过滤微小滚动，不执行赋值操作
                }

                // 原有回拉/切换逻辑不变
                val targetIndex = if (kotlin.math.abs(offset) >= itemWidth * 0.5f) {
                    if (offset < 0) (localCurrentIndex + 1).coerceIn(0, maxValidIndex)
                    else (localCurrentIndex - 1).coerceIn(0, maxValidIndex)
                } else {
                    localCurrentIndex
                }

                coroutineScope.launch {
                    lazyListState.animateScrollToItem(index = targetIndex)
                    topLazyListState.animateScrollToItem(index = targetIndex)
                    // 仅当滚动距离达标时，才更新currentID
                    if (targetIndex in 0 until myUps.size) {
                        currentID = myUps[targetIndex].ID
                    }
                }
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F2F2))
            .padding(top = 44.dp)
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(horizontal = all_horizonalPadding)
                .clip(shape = RoundedCornerShape(all_roundClip))
                .background(Color.White),
            state = topLazyListState
        ) {
            items(myUps) { item ->
                Up(
                    item.name,
                    item.avatar,
                    item.ID,
                    isSelected = item.ID == currentID,
                    { newId -> currentID = newId },
                )
                    }
            }
        Up_News( item = myUps,
            lazyListState = lazyListState,
            changeId = { newId ->
                currentID = newId
                }
            )
        }
    }


@Composable
fun Up(name:String,
       image:Int,
       id:Int,
       isSelected: Boolean, //接收选中状态
       changeID: (Int) -> Unit,
){
    val scale by animateFloatAsState(
        targetValue = if (isSelected) 1.1f else 1f,
        animationSpec = spring(),
    )

    val context = LocalContext.current

    val currentUpItem = remember(id) {
        myUps.firstOrNull { it.ID == id }
    }

    Box(
        modifier = Modifier
            .scale(scale)
            .height(120.dp)
            .width(80.dp)
            .padding(vertical = all_verticalPadding, horizontal = all_horizonalPadding)
            .pointerInput(Unit) { // Unit 表示无依赖，组件重组时不重置触摸状态
                detectTapGestures(
                    onPress = { changeID(id) },
                    onLongPress = {
                        val intent = Intent(context, Detail::class.java)

                        intent.putExtra("KEY_UP_ITEM_PARCELABLE",currentUpItem)

                        context.startActivity(intent)
                    }
                )
            }
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier.align(Alignment.Center)
        ){
            Image(painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                )
            Text(text = name,
                 style = TextStyle(
                     fontSize = 12.sp,
                     ),
                 overflow = TextOverflow.Ellipsis
                )
        }
    }
}




@Composable
fun Up_News(
    item: List<UpsList>,
    changeId: (Int) -> Unit,
    lazyListState: LazyListState, // 接收滚动状态
){
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp


    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = all_horizonalPadding,
                end = all_horizonalPadding,
                top = all_verticalPadding
            )
            .clip(shape = RoundedCornerShape(all_roundClip))
            .background(Color.White),
            state = lazyListState,
    ){
    items(item) { item ->

        Column(
            modifier = Modifier
                .width(screenWidth)
                .background(Color.White)
                .padding(horizontal = all_horizonalPadding)
        ) {  //某某某的动态
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(
                        start = all_horizonalPadding,
                        end = all_horizonalPadding,
                        top = all_verticalPadding
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${item.name}的视频动态",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = Bold,
                        letterSpacing = 2.sp
                    )
                )
            }

            Image(
                painter = painterResource(item.dynamis),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),

                contentScale = ContentScale.Crop //裁剪填充
            )

             }
         }
    }
}