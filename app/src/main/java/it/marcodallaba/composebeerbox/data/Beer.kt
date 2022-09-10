package it.marcodallaba.composebeerbox.data

import com.google.gson.annotations.SerializedName

data class Beer(
    val id: Int,
    val name: String,
    @field:SerializedName("tagline")
    val tagLine: String?,
    val description: String?,
    @field:SerializedName("image_url")
    val imageUrl: String?,
    val ebc: Float
)