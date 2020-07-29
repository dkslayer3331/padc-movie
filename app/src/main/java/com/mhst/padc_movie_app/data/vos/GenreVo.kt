package com.mhst.padc_movie_app.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by Moe Htet on 29,July,2020
 */

data class GenreVo(
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String
)