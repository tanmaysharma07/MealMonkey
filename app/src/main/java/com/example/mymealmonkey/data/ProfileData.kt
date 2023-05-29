package com.example.mymealmonkey.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("profile_table")
data class ProfileData(
    @PrimaryKey(true)
    val id:Int?,
    @ColumnInfo("name")
    val name:String?,
    @ColumnInfo("email")
    val email:String?,
    @ColumnInfo("mobileNumber")
    val mobileNo:String?,
    @ColumnInfo("address")
    val address:String?,
    @ColumnInfo("password")
    val password:String?
)
