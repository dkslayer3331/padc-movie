package com.mhst.padc_movie_app.persistance.typeconverters

import android.graphics.Movie
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mhst.padc_movie_app.data.vos.MovieVO

class MovieTypeConverter{
    @TypeConverter
    fun toString(list : List<MovieVO>) : String{
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(movieStr : String) : List<MovieVO>{
        val commentListType = object : TypeToken<ArrayList<MovieVO>>() {}.type
        return Gson().fromJson(movieStr, commentListType)
    }

}