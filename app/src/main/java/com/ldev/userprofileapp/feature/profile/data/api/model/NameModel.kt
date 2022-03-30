package com.ldev.userprofileapp.feature.profile.data.api.model

import com.google.gson.annotations.SerializedName

data class NameModel(
    @SerializedName("title")
    val title: String,
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String,
    @SerializedName("dob")
    val dob: DobModel
)