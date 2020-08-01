package com.mhst.padc_movie_app.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.mhst.padc_movie_app.persistance.typeconverters.PersonTypeConverter

/**
 * Created by Moe Htet on 31,July,2020
 */
@Entity(tableName = "persons")
@TypeConverters(PersonTypeConverter::class)
data class PersonVO(
    @PrimaryKey
    @SerializedName("id")
    val id : Long,
    @SerializedName("name")
    val name : String,
    @SerializedName("profile_path")
    val profilePath : String,
    var isFav : Boolean = false
)