package com.ldev.userprofileapp.feature.profile.data.api

class ProfileRepoImpl(private val remoteSource: ProfileScreenRemoteSource) : ProfileRepo {
    override suspend fun getProfile() {
        return remoteSource.getProfile() //TODO map to domainModel
    }
}