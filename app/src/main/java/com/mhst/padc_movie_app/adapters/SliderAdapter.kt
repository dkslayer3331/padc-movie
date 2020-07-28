package com.mhst.padc_movie_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mhst.padc_movie_app.R
import com.mhst.padc_movie_app.adapters.SliderAdapter.SliderViewHolder
import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.slider_viewholder.view.*

/**
 * Created by Moe Htet on 28,July,2020
 */
class SliderAdapter : SliderViewAdapter<SliderViewHolder>() {

    var imageList = mutableListOf<String>()

    fun setNewData(imgList : MutableList<String>){
        imageList = imgList
        notifyDataSetChanged()
    }




    class SliderViewHolder(itemView : View) : SliderViewAdapter.ViewHolder(itemView) {
        val ivSlider = itemView.ivSlider
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SliderViewHolder {
       val view = LayoutInflater.from(parent?.context).inflate(R.layout.slider_viewholder,parent,false)
        return SliderViewHolder(view)
    }

    override fun getCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(viewHolder: SliderViewHolder?, position: Int){
            viewHolder?.let {
                Glide.with(it.itemView).load(imageList[position]).into(viewHolder.ivSlider)
            }
    }


}
