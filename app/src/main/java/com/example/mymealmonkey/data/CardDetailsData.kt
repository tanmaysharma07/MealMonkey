package com.example.mymealmonkey.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("card_details_table")
data class CardDetailsData(
    @PrimaryKey
    val id: Int?,
    @ColumnInfo
    val cardNumber: String?,
    @ColumnInfo
    val expiryMonth: String?,
    @ColumnInfo
    val expiryYear: String?,
    @ColumnInfo
    val securityCode: String?,
    @ColumnInfo
    val firstName: String?,
    @ColumnInfo
    val lastName: String?,
)