package com.ldev.userprofileapp.feature.profile.data.api.model

import com.google.gson.annotations.SerializedName

data class MainModel(
    @SerializedName("results")
    val results: List<ProfileModel>
)
