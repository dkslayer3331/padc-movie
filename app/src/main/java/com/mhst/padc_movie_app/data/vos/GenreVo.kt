package com.mhst.padc_movie_app.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Moe Htet on 29,July,2020
 */
@Entity(tableName = "genres")
data class GenreVo(
    @PrimaryKey
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String
)