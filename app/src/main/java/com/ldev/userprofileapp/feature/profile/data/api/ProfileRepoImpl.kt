package com.ldev.userprofileapp.feature.profile.data.api

import com.ldev.userprofileapp.feature.profile.domain.model.ProfileDomainModel

class ProfileRepoImpl(private val remoteSource: ProfileRemoteSource) : ProfileRepo {
    override suspend fun getProfile(): ProfileDomainModel? {
        return remoteSource.getProfile().toDomain()
    }
}