package com.mhst.padc_movie_app.network.responses

import com.google.gson.annotations.SerializedName
import com.mhst.padc_movie_app.data.vos.PersonVO

/**
 * Created by Moe Htet on 31,July,2020
 */
data class PopularPersonResponse(
    @SerializedName("results")
    val result : List<PersonVO>
)