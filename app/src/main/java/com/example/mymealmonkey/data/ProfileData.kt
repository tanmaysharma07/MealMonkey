package com.example.mymealmonkey.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("profile_table")
data class ProfileData(
    @PrimaryKey(true)
    val id: Int? = null,
    @ColumnInfo("name")
    val name: String? = null,
    @ColumnInfo("email")
    val email: String? = null,
    @ColumnInfo("mobileNumber")
    val mobileNo: String? = null,
    @ColumnInfo("address")
    val address: String? = null,
    @ColumnInfo("password")
    val password: String? = null
)
