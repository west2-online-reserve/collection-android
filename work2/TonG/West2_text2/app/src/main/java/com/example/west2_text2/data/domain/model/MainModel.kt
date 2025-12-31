package com.example.west2_text2.data.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UpsList(
    val name : String,
    val avatar : Int,
    val dynamis:Int,
    val ID : Int,

    val fans:Int,
    val like:Int,
    val news:Int,

    val isLike: Boolean

): Parcelable