package com.mhst.padc_movie_app.network.responses

import com.google.gson.annotations.SerializedName
import com.mhst.padc_movie_app.data.vos.GenreVo

/**
 * Created by Moe Htet on 29,July,2020
 */
data class GenreResponse(
    @SerializedName("genres")
    val genres : List<GenreVo>
)