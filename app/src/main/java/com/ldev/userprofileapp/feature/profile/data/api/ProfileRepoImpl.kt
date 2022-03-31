package com.ldev.userprofileapp.feature.profile.data.api

import com.ldev.userprofileapp.feature.profile.data.bd.ProfileLocalSource
import com.ldev.userprofileapp.feature.profile.data.bd.toDomain
import com.ldev.userprofileapp.feature.profile.data.bd.toEntity
import com.ldev.userprofileapp.feature.profile.domain.model.ProfileDomainModel

class ProfileRepoImpl(
    private val remoteSource: ProfileRemoteSource,
    private val localSource: ProfileLocalSource
) : ProfileRepo {
    override suspend fun getProfile(): ProfileDomainModel? {
        return localSource.getLocalProfile()?.toDomain() ?: updateProfile()
    }

    override suspend fun updateProfile(): ProfileDomainModel? {
        val profile = remoteSource.getProfile().toDomain()
        profile?.let { localSource.saveProfile(it.toEntity()) }
        return profile
    }
}