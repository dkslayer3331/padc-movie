package com.mhst.padc_movie_app.data.vos

import androidx.room.Entity
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.mhst.padc_movie_app.persistance.typeconverters.GenreTypeConverter
import com.mhst.padc_movie_app.persistance.typeconverters.MovieTypeConverter

@Entity(tableName = "movies")
@TypeConverters(MovieTypeConverter::class,GenreTypeConverter::class)
data class MovieVO(
    @SerializedName("id")
    val id : Long,
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