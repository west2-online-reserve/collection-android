package com.example.west2_text2.data.domain.model

import com.example.west2_text2.R



enum class MyHomeTypes {
    ZhuYe, DongTai, TouGao, ZuiFan,
}

data class MyHomeTypeOrder(
    val name:String, val type: MyHomeTypes,
)