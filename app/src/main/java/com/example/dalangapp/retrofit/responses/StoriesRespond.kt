package com.example.dalangapp.retrofit.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class StoriesRespond(

    @field:SerializedName("msg")
    val msg: String,

    @field:SerializedName("data")
    val data: ArrayList<ListStoryItems>,

    @field:SerializedName("error")
    val error: String
)

@Parcelize
data class ListStoryItems(

    @field:SerializedName("image")
    val image: Int,

    @field:SerializedName("createdAt")
    val createdAt: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("url")
    val url: Int,

    @field:SerializedName("updatedAt")
    val updatedAt: String
):Parcelable
