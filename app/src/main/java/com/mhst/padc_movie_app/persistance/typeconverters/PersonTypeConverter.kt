package com.mhst.padc_movie_app.persistance.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mhst.padc_movie_app.data.vos.PersonVO

/**
 * Created by Moe Htet on 31,July,2020
 */
class PersonTypeConverter {
    @TypeConverter
    fun toString(list : List<PersonVO>) : String{
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(jsonStr : String) : List<PersonVO>{
        val listType = object : TypeToken<ArrayList<PersonVO>>() {}.type
        return Gson().fromJson(jsonStr, listType)
    }
}