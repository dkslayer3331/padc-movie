package com.mhst.padc_movie_app.views.viewpods

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.lable_and_text_viewpod.view.*

class LabelAndDescViewpod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    fun binData(label : String,data : String){
        tvLabel.text = label
        tvViewpodDesc.text = data
    }


}