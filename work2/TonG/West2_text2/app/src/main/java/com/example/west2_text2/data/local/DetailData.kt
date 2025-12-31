package com.example.west2_text2.data.local

import com.example.west2_text2.data.domain.model.MyHomeTypeOrder
import com.example.west2_text2.data.domain.model.MyHomeTypes


val myHomeTypes=listOf(
    MyHomeTypeOrder("演出", MyHomeTypes.ZhuYe),
    MyHomeTypeOrder("动态", MyHomeTypes.DongTai),
    MyHomeTypeOrder("投稿", MyHomeTypes.TouGao),
    MyHomeTypeOrder("追番", MyHomeTypes.ZuiFan),
)