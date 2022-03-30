package com.ldev.userprofileapp.feature.profile.data.api

import com.ldev.userprofileapp.feature.base.utils.toDate
import com.ldev.userprofileapp.feature.profile.data.api.model.CoordinatesModel
import com.ldev.userprofileapp.feature.profile.data.api.model.MainModel
import com.ldev.userprofileapp.feature.profile.domain.model.CoordinatesDomainModel
import com.ldev.userprofileapp.feature.profile.domain.model.ProfileDomainModel
import java.util.*

fun CoordinatesModel.toDomain() = CoordinatesDomainModel(
    latitude = latitude,
    longitude = longitude
)

fun MainModel.toDomain(): ProfileDomainModel? {
    val profile = this.results.firstOrNull()
    val date = Calendar.getInstance().time
    return profile?.let {
        ProfileDomainModel(
            name = "${it.name.title} ${it.name.first} ${it.name.last}",
            picture = it.picture.large,
            phone = it.phone,
            country = it.location.country,
            city = it.location.city,
            street = it.location.street.name,
            coordinates = it.location.coordinates.toDomain(),
            dateOfBirth = it.dob.date.toDate()
        )
    }
}