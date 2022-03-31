package com.ldev.userprofileapp.feature.profile.data.bd.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = ProfileEntity.TABLE_NAME)
data class ProfileEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "picture")
    val picture: String,
    @ColumnInfo(name = "date_of_birth")
    val dateOfBirth: String,
    @ColumnInfo(name = "phone")
    val phone: String,
    @ColumnInfo(name = "country")
    val country: String,
    @ColumnInfo(name = "city")
    val city: String,
    @ColumnInfo(name = "street")
    val street: String,
    @Embedded
    val coordinates: CoordinatesEntity,

    ) {
    companion object {
        const val TABLE_NAME = "PROFILE_TABLE"
    }
}
