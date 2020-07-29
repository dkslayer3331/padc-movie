package com.mhst.padc_movie_app.data.vos

import com.google.gson.annotations.SerializedName

data class MovieVO(
    @SerializedName("popularity")
    val popularity : Float,
    @SerializedName("vote_count")
    val voteCount : Long,
    @SerializedName("video")
    val video : Boolean,
    @SerializedName("poster_path")
    val posterPath : String,
    @SerializedName("original_language")
    val originalLang : String,
    @SerializedName("original_title")
    val originalTitle : String,
    @SerializedName("genre_ids")
    val genres : List<String> = listOf(),
    @SerializedName("title")
    val title : String,
    @SerializedName("vote_average")
    val voteAvg : Float,
    @SerializedName("overview")
    val overview : String,
    @SerializedName("release_date")
    val releaseDate : String
)