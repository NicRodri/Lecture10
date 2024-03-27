package com.bcit.lecture10.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class LocalUser(
    @PrimaryKey(autoGenerate = true) val uid : Int? = null,
    @ColumnInfo(name = "user_name") val userName: String?,
    val email: String

)