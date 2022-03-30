package com.ldev.userprofileapp.feature.profile.data.api.model

import com.google.gson.annotations.SerializedName

data class StreetModel(
    @SerializedName("number")
    val number: Int,
    @SerializedName("name")
    val name: String
)
