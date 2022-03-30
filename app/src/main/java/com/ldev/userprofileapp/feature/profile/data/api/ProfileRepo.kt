package com.ldev.userprofileapp.feature.profile.data.api

interface ProfileRepo {
    suspend fun getProfile() //TODO set domainModel
}