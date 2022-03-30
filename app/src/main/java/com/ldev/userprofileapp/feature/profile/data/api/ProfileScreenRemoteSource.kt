package com.ldev.userprofileapp.feature.profile.data.api

import com.ldev.userprofileapp.feature.profile.data.api.model.MainModel

class ProfileScreenRemoteSource(private val api: ProfileScreenApi) {
    suspend fun getProfile(): MainModel {
        return api.getProfile()
    }
}