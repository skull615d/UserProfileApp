package com.ldev.userprofileapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ldev.userprofileapp.feature.profile.data.bd.ProfileDAO
import com.ldev.userprofileapp.feature.profile.data.bd.model.ProfileEntity

@Database(entities = [ProfileEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getProfileDAO(): ProfileDAO
}