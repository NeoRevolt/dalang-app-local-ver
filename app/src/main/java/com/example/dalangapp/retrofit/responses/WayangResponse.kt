package com.example.dalangapp.retrofit.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class WayangResponse(

	@field:SerializedName("msg")
	val msg: String,

	@field:SerializedName("data")
	val data: WayangData,

	@field:SerializedName("error")
	val error: String
)
@Parcelize
data class WayangData(

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("createdAt")
	val createdAt: String,

	@field:SerializedName("origin")
	val origin: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("source")
	val source: String,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("updatedAt")
	val updatedAt: String
):Parcelable
