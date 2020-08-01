package com.mhst.padc_movie_app.network.responses

import com.google.gson.annotations.SerializedName
import com.mhst.padc_movie_app.data.vos.VideoVO

/**
 * Created by Moe Htet on 01,August,2020
 */
data class VideosResponsee(
    @SerializedName("results")
    val videos : List<VideoVO>
)