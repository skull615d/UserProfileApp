package com.ldev.userprofileapp.feature.profile.data.api

import com.ldev.userprofileapp.feature.profile.data.api.model.CoordinatesModel
import com.ldev.userprofileapp.feature.profile.data.api.model.MainModel
import com.ldev.userprofileapp.feature.profile.domain.model.CoordinatesDomainModel
import com.ldev.userprofileapp.feature.profile.domain.model.ProfileDomainModel

fun CoordinatesModel.toDomain() = CoordinatesDomainModel(
    latitude = latitude,
    longitude = longitude
)

fun MainModel.toDomain(): ProfileDomainModel? {
    val profile = this.results.firstOrNull()
    return profile?.let {
        ProfileDomainModel(
            name = "${it.name.title} ${it.name.first} ${it.name.last}",
            picture = it.picture.medium,
            phone = it.phone,
            country = it.location.country,
            city = it.location.city,
            street = it.location.street.name,
            coordinates = it.location.coordinates.toDomain(),
            dateOfBirth = //TODO set dateOfBirth
        )
    }
}