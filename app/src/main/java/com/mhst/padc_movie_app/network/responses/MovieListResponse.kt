package com.mhst.padc_movie_app.network.responses

import com.google.gson.annotations.SerializedName
import com.mhst.padc_movie_app.data.vos.MovieVO

data class MovieListResponse(
    @SerializedName("page")
    val int : Int = 1,
    @SerializedName("total_results")
    val totalResults : Int,
    @SerializedName("total_pages")
    val totalPage : Int,
    @SerializedName("results")
    val movies : List<MovieVO>
)