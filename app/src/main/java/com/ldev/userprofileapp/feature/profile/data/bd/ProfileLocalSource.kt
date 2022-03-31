package com.ldev.userprofileapp.feature.profile.data.bd

import com.ldev.userprofileapp.feature.profile.data.bd.model.ProfileEntity

class ProfileLocalSource(private val dao: ProfileDAO) {
    suspend fun saveProfile(profileEntity: ProfileEntity) {
        dao.create(profileEntity)
    }

    suspend fun getLocalProfile(): ProfileEntity? {
        return dao.read()
    }
}