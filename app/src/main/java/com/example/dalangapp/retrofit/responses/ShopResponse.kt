package com.example.dalangapp.retrofit.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class ShopResponse(

	@field:SerializedName("msg")
	val msg: String,

	@field:SerializedName("data")
	val data: ArrayList<ListShopItems>,

	@field:SerializedName("error")
	val error: String
)

@Parcelize
data class ListShopItems(

	@field:SerializedName("image")
	val image: Int,

	@field:SerializedName("photoUrl")
	val photoUrl: Int,

	@field:SerializedName("createdAt")
	val createdAt: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("linkUrl")
	val linkUrl: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("updatedAt")
	val updatedAt: String
): Parcelable
