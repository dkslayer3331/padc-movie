package com.mhst.padc_movie_app.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.mhst.padc_movie_app.adapters.ActorAdapter
import com.mhst.padc_movie_app.data.vos.PersonVO
import kotlinx.android.synthetic.main.viewpod_actors_recycler.view.*

/**
 * Created by Moe Htet on 01,August,2020
 */
class ActorsRecyclerViewpod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    fun bindActors(actors : List<PersonVO>){
        val actorAdapter = ActorAdapter()
        rvPerson.adapter = actorAdapter
        actorAdapter.setNewData(actors.toMutableList())
    }


}