package com.ldev.userprofileapp.feature.profile.di

import com.ldev.userprofileapp.feature.profile.data.api.ProfileApi
import com.ldev.userprofileapp.feature.profile.data.api.ProfileRemoteSource
import com.ldev.userprofileapp.feature.profile.data.api.ProfileRepo
import com.ldev.userprofileapp.feature.profile.data.api.ProfileRepoImpl
import com.ldev.userprofileapp.feature.profile.data.bd.ProfileDAO
import com.ldev.userprofileapp.feature.profile.data.bd.ProfileLocalSource
import com.ldev.userprofileapp.feature.profile.domain.ProfileInteractor
import com.ldev.userprofileapp.feature.profile.ui.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val profileModule = module {
    single<ProfileApi> {
        get<Retrofit>().create(ProfileApi::class.java)
    }

    single<ProfileRemoteSource> {
        ProfileRemoteSource(get<ProfileApi>())
    }

    single<ProfileLocalSource> {
        ProfileLocalSource(get<ProfileDAO>())
    }


    single<ProfileRepo> {
        ProfileRepoImpl(get<ProfileRemoteSource>(), get<ProfileLocalSource>())
    }

    single<ProfileInteractor> {
        ProfileInteractor(get<ProfileRepo>())
    }

    viewModel {
        ProfileViewModel(get<ProfileInteractor>())
    }
}