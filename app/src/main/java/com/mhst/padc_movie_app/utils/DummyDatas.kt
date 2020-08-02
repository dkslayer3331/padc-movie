package com.mhst.padc_movie_app.utils

import com.mhst.padc_movie_app.data.vos.GenreVo
import com.mhst.padc_movie_app.data.vos.MovieDetailVO
import com.mhst.padc_movie_app.data.vos.MovieVO
import com.mhst.padc_movie_app.data.vos.PersonVO

/**
 * Created by Moe Htet on 02,August,2020
 */

object DummyDatas{

     fun getMovieList() : List<MovieVO>{
        val list = mutableListOf<MovieVO>()
        for(i in 1..5L){
            list.add(
                MovieVO(i,1.5f,20,false,
                    "", "lang $i",
                    "title $i", listOf(),"title $i",3.4f,"","")
            )
        }
        return  list
    }

     fun getAllPeople() : List<PersonVO>{
        val list = mutableListOf<PersonVO>()
        for(i in 1..5L){
            list.add(PersonVO(i,"name $i","profilepath $i",false))
        }
        return list
    }

     fun getAllGenres() : List<GenreVo>{
        val list = mutableListOf<GenreVo>()
        for(i in 1..5){
            list.add(GenreVo(i,"genre $i"))
        }
        return list
    }

    fun getDummyDetail(id : Int) : MovieDetailVO{
        return MovieDetailVO(false,"", listOf(),id)
    }

}

