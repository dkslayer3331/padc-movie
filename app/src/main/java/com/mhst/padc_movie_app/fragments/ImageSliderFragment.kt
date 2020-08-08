package com.mhst.padc_movie_app.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.mhst.padc_movie_app.R
import com.mhst.padc_movie_app.activities.VideoPlayerActivity
import com.mhst.padc_movie_app.utils.next_lvl_url
import kotlinx.android.synthetic.main.fragment_image_slider.*

/**
 * Created by Moe Htet on 01,August,2020
 */
class ImageSliderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image_slider,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = arguments?.getString(IMAGE_URL_KEY)
        val movieId = arguments?.getInt(ID_KEY)
        Log.d("insideFragment",url)
        Glide.with(view.context).load(next_lvl_url+url).into(ivSliderImage)
        btnPlaySlider.setOnClickListener {
           startActivity(VideoPlayerActivity.onNewIntent(context!!,movieId!!))
        }
    }

    companion object{

        private const val IMAGE_URL_KEY = "imageUrlKey"

        const val ID_KEY = "sliderIdKey"

        fun newInstance(url : String,id : Int) : ImageSliderFragment{
            val fragment = ImageSliderFragment()
            val bundle = Bundle()
            bundle.putString(IMAGE_URL_KEY,url)
            bundle.putInt(ID_KEY,id)
            fragment.arguments = bundle
            return fragment
        }
    }

}