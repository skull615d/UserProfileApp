package com.ldev.userprofileapp.feature.profile.di

import com.ldev.userprofileapp.feature.profile.data.api.ProfileApi
import com.ldev.userprofileapp.feature.profile.data.api.ProfileRemoteSource
import com.ldev.userprofileapp.feature.profile.data.api.ProfileRepo
import com.ldev.userprofileapp.feature.profile.data.api.ProfileRepoImpl
import com.ldev.userprofileapp.feature.profile.domain.ProfileInteractor
import org.koin.dsl.module
import retrofit2.Retrofit

val profileModule = module {
    single<ProfileApi> {
        get<Retrofit>().create(ProfileApi::class.java)
    }

    single<ProfileRemoteSource> {
        ProfileRemoteSource(get<ProfileApi>())
    }

    single<ProfileRepo> {
        ProfileRepoImpl(get<ProfileRemoteSource>())
    }

    single<ProfileInteractor> {
        ProfileInteractor(get<ProfileRepo>())
    }
}