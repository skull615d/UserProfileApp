package com.ldev.userprofileapp.feature.profile.domain

import com.ldev.userprofileapp.feature.profile.data.api.ProfileRepo
import com.ldev.userprofileapp.feature.profile.domain.model.ProfileDomainModel

class ProfileInteractor(private val profileRepo: ProfileRepo) {

    suspend fun getProfile(): ProfileDomainModel? {
        return profileRepo.getProfile()
    }
}