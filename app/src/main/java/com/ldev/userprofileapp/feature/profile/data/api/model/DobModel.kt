package com.ldev.userprofileapp.feature.profile.data.api.model

import com.google.gson.annotations.SerializedName

data class DobModel(
    @SerializedName("date")
    val date: String
)
