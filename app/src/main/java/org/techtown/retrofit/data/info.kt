package org.techtown.retrofit.data


import com.google.gson.annotations.SerializedName

data class info(
    @SerializedName("response")
    val response: Response?
)