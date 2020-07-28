package com.mhst.padc_movie_app

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import com.mhst.padc_movie_app.adapters.SliderAdapter
import com.smarteist.autoimageslider.SliderAnimations
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: SliderAdapter

    private fun setupSlider(){
        adapter = SliderAdapter()
        adapter.setNewData(sliderUrlList)
        posterSlider.apply {
            startAutoCycle()
            setSliderAdapter(adapter)
            setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
            indicatorSelectedColor = Color.YELLOW
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupSlider()
    }
}