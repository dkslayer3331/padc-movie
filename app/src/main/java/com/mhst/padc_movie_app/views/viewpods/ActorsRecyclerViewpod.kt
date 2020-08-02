package com.mhst.padc_movie_app.views.viewpods

import android.content.Context
import android.provider.Settings.System.getString
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.core.text.HtmlCompat
import com.mhst.padc_movie_app.R
import com.mhst.padc_movie_app.adapters.ActorAdapter
import com.mhst.padc_movie_app.data.vos.PersonVO
import com.mhst.padc_movie_app.mvp.presenter.MainPresenter
import kotlinx.android.synthetic.main.viewpod_actors_recycler.view.*

/**
 * Created by Moe Htet on 01,August,2020
 */
class ActorsRecyclerViewpod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    fun bindActors(actors : List<PersonVO>,mainPresenter: MainPresenter){
        val actorAdapter = ActorAdapter(mainPresenter)
        rvPerson.adapter = actorAdapter
        tvLabelMoreActors.text = HtmlCompat.fromHtml(context.getString(R.string.more_actors), HtmlCompat.FROM_HTML_MODE_LEGACY)
        actorAdapter.setNewData(actors.toMutableList())
    }


}