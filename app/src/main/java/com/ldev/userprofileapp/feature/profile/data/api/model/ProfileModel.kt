package com.ldev.userprofileapp.feature.profile.data.api.model

import com.google.gson.annotations.SerializedName

data class ProfileModel(
    @SerializedName("name")
    val name: NameModel,
    @SerializedName("picture")
    val picture: PictureModel,
    @SerializedName("location")
    val location: LocationModel,
    @SerializedName("phone")
    val phone: String,
)
