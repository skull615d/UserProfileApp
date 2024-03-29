package com.ldev.userprofileapp.feature.profile.domain

import com.ldev.userprofileapp.base.view_model.attempt
import com.ldev.userprofileapp.feature.profile.data.api.ProfileRepo

class ProfileInteractor(private val profileRepo: ProfileRepo) {

    suspend fun getProfile() = attempt { profileRepo.getProfile() }
    suspend fun updateProfile() = attempt { profileRepo.updateProfile() }
}