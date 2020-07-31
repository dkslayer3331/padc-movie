package com.mhst.padc_movie_app.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by Moe Htet on 01,August,2020
 */
data class CrewVO(
    @SerializedName("credit_id") val creditId: String= "",
    @SerializedName("department") val department: String = "",
    @SerializedName("gender") val gender: Int = 0,
    @SerializedName("id") val id: Int = 0,
    @SerializedName("job") val job: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("profile_path") val profilePath: String = ""
)