package com.mhst.padc_movie_app.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by Moe Htet on 01,August,2020
 */
data class CastVO(
    @SerializedName("cast_id") val castId: Int = 1,
    @SerializedName("character") val character: String = "",
    @SerializedName("credit_id") val creditId: String = "",
    @SerializedName("gender") val gender: Int = 0,
    @SerializedName("id") val id: Int = 0,
    @SerializedName("name") val name: String = "",
    @SerializedName("order") val order: Int = 0,
    @SerializedName("profile_path") val profilePath: String? = ""
)