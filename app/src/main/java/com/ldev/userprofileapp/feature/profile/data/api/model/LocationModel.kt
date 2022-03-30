package com.ldev.userprofileapp.feature.profile.data.api.model

import com.google.gson.annotations.SerializedName

data class LocationModel(
    @SerializedName("country")
    val country: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("street")
    val street: StreetModel,
    @SerializedName("coordinates")
    val coordinates: CoordinatesModel
)
