package com.mhst.padc_movie_app.mvp.view

import com.mhst.padc_movie_app.data.vos.MovieDetailVO
import com.mhst.shared.BaseView

/**
 * Created by Moe Htet on 01,August,2020
 */
interface DetailView : BaseView {
    fun showDetail(movieDetailVO: MovieDetailVO)
    fun showSwipeRefresh()
    fun hideSwipeRefresh()
}