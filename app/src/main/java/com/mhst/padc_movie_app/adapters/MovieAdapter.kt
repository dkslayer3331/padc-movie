package com.mhst.padc_movie_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mhst.padc_movie_app.R
import com.mhst.padc_movie_app.data.vos.MovieVO
import com.mhst.padc_movie_app.delegate.TapDelegate
import com.mhst.padc_movie_app.views.viewholders.MovieViewHolder
import com.mhst.shared.BaseRecyclerAdapter

class MovieAdapter(val tapDelegate: TapDelegate) : BaseRecyclerAdapter<MovieViewHolder, MovieVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_movie_viewpod,parent,false)
        return  MovieViewHolder(view,tapDelegate)
    }
}