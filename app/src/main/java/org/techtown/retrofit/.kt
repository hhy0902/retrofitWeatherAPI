package org.techtown.retrofit


import com.google.gson.annotations.SerializedName

data class qwerasdf (
    @SerializedName("components")
    val components: Components?,
    @SerializedName("dt")
    val dt: Int?,
    @SerializedName("main")
    val main: MainX?
)