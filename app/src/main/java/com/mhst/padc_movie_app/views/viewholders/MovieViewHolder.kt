package com.mhst.padc_movie_app.views.viewholders

import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.mhst.padc_movie_app.data.vos.MovieVO
import com.mhst.padc_movie_app.delegate.TapDelegate
import com.mhst.padc_movie_app.utils.next_lvl_url
import com.mhst.shared.BaseViewHolder
import kotlinx.android.synthetic.main.popular_movie_viewpod.view.*

class MovieViewHolder(val itemView: View,val tapDelegate: TapDelegate) : BaseViewHolder<MovieVO>(itemView) {

    init {
       itemView.setOnClickListener {
           Log.d("iddd",mData?.id.toString())
           tapDelegate.onTap((mData as MovieVO?)?.id?.toInt() ?: 0)
       }
    }

    override fun bindData(data: MovieVO){
        mData = data
        Glide.with(itemView.context).load("${next_lvl_url}${data.posterPath}").into(itemView.ivMoviePoster)
        itemView.tvMovieName.text = data.originalTitle
        itemView.rbMovieRating.rating = data.voteAvg
        itemView.tvVoteCount.text = data.voteCount.toString()
    }
}