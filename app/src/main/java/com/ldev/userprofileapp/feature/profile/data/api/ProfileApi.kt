package com.ldev.userprofileapp.feature.profile.data.api

import com.ldev.userprofileapp.feature.base.constants.Constants
import com.ldev.userprofileapp.feature.profile.data.api.model.MainModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ProfileApi {
    @GET(Constants.BASE_PROFILE_PATH)
    suspend fun getProfile(
        @Query("inc") inc: String = "name,picture,location,phone"
    ): MainModel
}