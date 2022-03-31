package com.ldev.userprofileapp.feature.profile.data.bd

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ldev.userprofileapp.base.constants.Constants
import com.ldev.userprofileapp.feature.profile.data.bd.model.ProfileEntity

@Dao
interface ProfileDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(profileEntity: ProfileEntity)

    @Query("SELECT * FROM ${ProfileEntity.TABLE_NAME} WHERE id =:id")
    suspend fun read(id: Int = Constants.ID_PROFILE): ProfileEntity?
}