package com.example.west2_text2.screens

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.west2_text2.MainActivity
import com.example.west2_text2.R
import com.example.west2_text2.data.domain.model.MyHomeTypeOrder
import com.example.west2_text2.data.domain.model.MyHomeTypes
import com.example.west2_text2.data.domain.model.UpsList
import com.example.west2_text2.data.local.myHomeTypes
import com.example.west2_text2.ui.theme.West2_text2Theme
import com.example.west2_text2.ui.theme.all_horizonalPadding
import com.example.west2_text2.ui.theme.all_roundClip
import com.example.west2_text2.ui.theme.all_verticalPadding



class Detail : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            //接收数据
            val receivedUpItem: UpsList = intent.getParcelableExtra("KEY_UP_ITEM_PARCELABLE", UpsList::class.java)!!

            West2_text2Theme {

                LazyColumn(modifier = Modifier.fillMaxSize()){
                item{MainImage()}
                item{
                    MyCards(
                        receivedUpItem,
                        onReturnData = { modifiedItem ->
                            // 执行Activity的返回逻辑  //貌似这个回调没啥用处QAQ
                            val returnIntent = Intent()
                            returnIntent.putExtra("KEY_MODIFIED_UP_ITEM", modifiedItem)
                            setResult(RESULT_OK, returnIntent)
                            finish()
                        },
                    )
                }

                item{ MyOrders() }
                }

                Topbar()

                }
            }
        }
    }


@Composable
fun Topbar(
){
    val context = LocalContext.current
    val detailActivity = context as ComponentActivity

    Row(modifier = Modifier
        .padding(top = all_verticalPadding+4.dp, start = all_horizonalPadding + 10.dp)
        .fillMaxWidth()
        .height(60.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(painter = painterResource(R.drawable.icon_back),
            contentDescription = "back",
            modifier = Modifier
                .size(30.dp)
                .alpha(0.5f)
                .clickable {
                    val intent = Intent(context, MainActivity::class.java).apply {
                        // 核心Flags：两个标记组合使用，实现“真正的返回”效果
                        // 1. FLAG_ACTIVITY_CLEAR_TOP：清除MainActivity之上的所有Activity（包括Detail）
                        // 2. FLAG_ACTIVITY_SINGLE_TOP：若MainActivity已在栈顶（或存在），不重新创建，直接复用
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                    }
                    // 启动MainActivity（此时会复用栈中已存在的实例，不会重新创建）
                    context.startActivity(intent)
                    // 关闭Detail，避免栈中残留
                    detailActivity.finish()
                }
            )
    }
}



@Preview
@Composable
fun MainImage(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
    ){
        Image(painter = painterResource(R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}


@Composable
fun MyCards(item: UpsList,
            onReturnData: (UpsList) -> Unit,
){
    Box(modifier=Modifier
        .fillMaxWidth()
        .height(180.dp)
        .background(Color.White)
    ){

        //Toast
        val context = LocalContext.current
        var isLikeState by remember { mutableStateOf(item.isLike) }

        Image(painter = painterResource(item.avatar),
            contentDescription = null,
            modifier = Modifier
                .size(68.dp)
                .offset(30.dp, (-12).dp)
                .clip(CircleShape)

        )

        Column(modifier = Modifier
            .align(Alignment.TopEnd),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Row(horizontalArrangement = Arrangement.spacedBy(5.dp)){
                InfInMyCards("粉丝", if(!isLikeState)item.fans else item.fans+1,true)
                InfInMyCards("关注",item.news,true)
                InfInMyCards("获赞",item.like,false)
            }

            Row(modifier = Modifier
                .width(240.dp)
                .height(40.dp)
            ){

                if(!isLikeState) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(240.dp)
                            .padding(vertical = 4.dp)
                            .clip(RoundedCornerShape(all_roundClip))
                            .background(Color(0xFFF9598E))
                            .clickable {
                                isLikeState = !isLikeState
                                onReturnData

                                Toast.makeText(
                                    context,
                                    "关注成功！QWQ",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                    ) {
                        Text(
                            text = "+ 关注",
                            color = Color.White,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }

                else {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(240.dp)
                            .padding(vertical = 4.dp)
                            .clip(RoundedCornerShape(all_roundClip))
                            .background(Color(0xFFECECEC))
                            .clickable {
                                isLikeState = !isLikeState
                                onReturnData

                                Toast.makeText(
                                    context,
                                    "取消关注！QAQ",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                    ) {
                        Text(
                            text = "已关注",
                            color = Color.White,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }

            }

        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomStart)
            .padding(horizontal = 12.dp, vertical = 40.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ){
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(item.name,
                    style = TextStyle(
                        fontSize = 16.sp
                         ),
                    )
                Image(painter = painterResource(R.drawable.icon_lv6),
                    contentDescription = "LV6",
                    modifier = Modifier
                        .size(24.dp)
                        .offset(0.dp, 2.dp)
                    )
            }
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text("这是一个签名,这也是一个签名",
                    style = TextStyle(
                        fontSize = 10.sp
                    ),
                    color = Color.Gray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text("详情",
                    style = TextStyle(
                        fontSize = 10.sp
                    ),
                    color = Color(0xFF6F99A6),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}



@Composable
fun InfInMyCards(type:String,num:Int,isDraw:Boolean){
    Column(
        modifier = Modifier
            .height(65.dp)
            .width(80.dp)
//            .background(Color.White)
            .padding(top = all_verticalPadding),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "$num",
            style = TextStyle(
                fontSize = 18.sp,
            ),
            modifier = Modifier
        )

        Text(text = type,
            style = TextStyle(
                fontSize = 12.sp,
            ),
            color = Color.Gray,
            modifier = Modifier
        )
    }

    if(isDraw){
    Canvas(modifier = Modifier){
        drawLine(
            color = Color(0xFFECECEC),
            start = Offset(0.dp.toPx(),25.dp.toPx()),
            end =  Offset(0.dp.toPx(),45.dp.toPx()),
            strokeWidth = 1.dp.toPx()
        )
        }
    }
}





@Preview
@Composable
fun MyOrders(modifier:Modifier=Modifier){

    var curType by remember{ mutableStateOf(MyHomeTypes.ZhuYe) }

    Column(modifier = modifier.fillMaxSize()){
        TopLazy(modifier=modifier,myHomeTypes,curType=curType,{ curType = it })

    }
}



@Composable
fun TopLazy(modifier: Modifier =Modifier, items: List<MyHomeTypeOrder>, curType: MyHomeTypes, onTypeChange: (MyHomeTypes) -> Unit){
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val lazyWidth = screenWidth/4

    Row(
        modifier=modifier
            .height(40.dp)
            .fillMaxWidth()
            .background(Color.White)
    ) {
        items.forEach{ item ->
            Box(
                modifier=modifier
                    .height(40.dp)
                    .width(lazyWidth)
                    .clickable { onTypeChange(item.type) }//通过回调修改父组件状态，原代码直接赋值无法生效
            ){
                Text(text = item.name,
                    fontSize = 16.sp,
                    color = if (curType==item.type) Color(0xFF000000) else Color(0xFFA1A2A8),
                    modifier=modifier
                        .align(Alignment.Center)
                )
                if (curType==item.type) {
                    Box(
                        modifier = modifier
                            .width(24.dp)
                            .height(4.dp)
                            .background(Color(0xFFF9598E), RoundedCornerShape(24.dp))
                            .align(Alignment.BottomCenter)
                            .clip(RoundedCornerShape(24.dp))
                    )
                    {}
                }
            }
        }
    }
}