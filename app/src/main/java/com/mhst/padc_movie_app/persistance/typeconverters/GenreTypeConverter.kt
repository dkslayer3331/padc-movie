package com.mhst.padc_movie_app.persistance.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Moe Htet on 31,July,2020
 */
class GenreTypeConverter {

    @TypeConverter
    fun toString(list : List<String>) : String{
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(genreStr : String) : List<String>{
        val genres = object : TypeToken<ArrayList<String>>() {}.type
        return Gson().fromJson(genreStr, genres)
    }

}