package org.techtown.retrofit


import com.google.gson.annotations.SerializedName

data class Pollution(
    @SerializedName("coord")
    val coord: CoordX?,
    @SerializedName("list")
    val list: List<qwerasdf>?
)