package com.mhst.padc_movie_app.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.mhst.padc_movie_app.data.vos.MovieVO
import com.mhst.padc_movie_app.utils.POSTER_BASE_URL
import com.mhst.padc_movie_app.utils.next_lvl_url
import kotlinx.android.synthetic.main.popular_movie_viewpod.view.*

class MovieViewHolder(itemView: View) : BaseViewHolder<MovieVO>(itemView) {
    override fun bindData(data: MovieVO){
        Glide.with(itemView.context).load("${next_lvl_url}${data.posterPath}").into(itemView.ivMoviePoster)
        itemView.tvMovieName.text = data.originalTitle
        itemView.rbMovieRating.rating = data.voteAvg
        itemView.tvVoteCount.text = data.voteCount.toString()
    }
}