package com.mhst.padc_movie_app.models.vos

import com.google.gson.annotations.SerializedName

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