package com.mhst.padc_movie_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.mhst.padc_movie_app.R

/**
 * Created by Moe Htet on 29,July,2020
 */
class GenreListFragment : Fragment() {

    companion object{
         const val GENRE_ID_KEY = "genreId"
        fun newInstance() = GenreListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_genre_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
           arguments?.takeIf { it.containsKey(GENRE_ID_KEY) }?.apply{
               print("genre id is ${getInt(GENRE_ID_KEY)}")
           }
    }


}