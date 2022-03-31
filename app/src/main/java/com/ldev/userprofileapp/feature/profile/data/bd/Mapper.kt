package com.ldev.userprofileapp.feature.profile.data.bd

import com.ldev.userprofileapp.base.constants.Constants
import com.ldev.userprofileapp.base.utils.toDate
import com.ldev.userprofileapp.base.utils.toStringFormat
import com.ldev.userprofileapp.feature.profile.data.bd.model.CoordinatesEntity
import com.ldev.userprofileapp.feature.profile.data.bd.model.ProfileEntity
import com.ldev.userprofileapp.feature.profile.domain.model.CoordinatesDomainModel
import com.ldev.userprofileapp.feature.profile.domain.model.ProfileDomainModel

fun ProfileDomainModel.toEntity() = ProfileEntity(
    id = Constants.ID_PROFILE,
    name = name,
    picture = picture,
    dateOfBirth = dateOfBirth.toStringFormat(Constants.DATE_FORMAT_DB),
    phone = phone,
    country = country,
    city = city,
    street = street,
    coordinates = CoordinatesEntity(
        latitude = coordinates.latitude,
        longitude = coordinates.longitude
    )
)

fun ProfileEntity.toDomain() = ProfileDomainModel(
    name = name,
    picture = picture,
    dateOfBirth = dateOfBirth.toDate(Constants.DATE_FORMAT_DB),
    phone = phone,
    country = country,
    city = city,
    street = street,
    coordinates = CoordinatesDomainModel(
        latitude = coordinates.latitude,
        longitude = coordinates.longitude
    )
)