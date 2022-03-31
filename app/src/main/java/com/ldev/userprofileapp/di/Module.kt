package com.ldev.userprofileapp.di

import androidx.room.Room
import com.ldev.userprofileapp.AppDataBase
import com.ldev.userprofileapp.base.constants.Constants
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val DATA_BASE = "DATA_BASE"
val appModule = module {

    single {
        OkHttpClient.Builder()
            .build()
    }

    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_PROFILE_URL)
            .client(get())
            .build()
    }

    single {
        Room.databaseBuilder(androidContext(), AppDataBase::class.java, DATA_BASE)
            .fallbackToDestructiveMigration()// clears the database when the version changes
            .build()
    }

    single {
        get<AppDataBase>().getProfileDAO()
    }
}