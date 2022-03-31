package com.ldev.userprofileapp.feature.profile.data.api

import com.ldev.userprofileapp.feature.profile.domain.model.ProfileDomainModel

interface ProfileRepo {
    suspend fun getProfile(): ProfileDomainModel?
    suspend fun updateProfile(): ProfileDomainModel?
}