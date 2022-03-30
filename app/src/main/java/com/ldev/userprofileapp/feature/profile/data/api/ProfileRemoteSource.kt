package com.ldev.userprofileapp.feature.profile.data.api

import com.ldev.userprofileapp.feature.profile.data.api.model.MainModel

class ProfileRemoteSource(private val api: ProfileApi) {
    suspend fun getProfile(): MainModel {
        return api.getProfile()
    }
}