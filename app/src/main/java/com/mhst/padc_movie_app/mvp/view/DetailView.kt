package com.mhst.padc_movie_app.mvp.view

import com.mhst.padc_movie_app.data.vos.MovieDetailVO

/**
 * Created by Moe Htet on 01,August,2020
 */
interface DetailView : BaseView {
    fun showDetail(movieDetailVO: MovieDetailVO)
}