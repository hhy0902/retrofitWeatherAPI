package org.techtown.retrofit


import com.google.gson.annotations.SerializedName

data class MainX(
    @SerializedName("aqi")
    val aqi: Int?
)