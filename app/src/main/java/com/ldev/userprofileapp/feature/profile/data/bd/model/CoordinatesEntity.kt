package com.ldev.userprofileapp.feature.profile.data.bd.model

import androidx.room.ColumnInfo

data class CoordinatesEntity(
    @ColumnInfo(name = "latitude")
    val latitude: Double,
    @ColumnInfo(name = "longitude")
    val longitude: Double,
)
