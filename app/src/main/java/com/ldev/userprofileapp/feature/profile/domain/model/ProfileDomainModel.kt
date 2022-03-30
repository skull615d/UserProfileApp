package com.ldev.userprofileapp.feature.profile.domain.model

import java.util.*

data class ProfileDomainModel(
    val name: String,
    val picture: String,
    val dateOfBirth: Date,
    val phone: String,
    val country: String,
    val city: String,
    val street: String,
    val coordinates: CoordinatesDomainModel
)
