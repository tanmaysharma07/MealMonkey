package com.example.mymealmonkey.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mymealmonkey.data.CardDetailsData


@Dao
interface CardDetailsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cardDetailsData: CardDetailsData)

    @Delete
    suspend fun delete(cardDetailsData: CardDetailsData)

    @Query("Delete From card_details_table where cardNumber=:cardNumber")
    fun deleteCard(cardNumber: String)

    @Query("Update card_details_table Set expiryMonth =:expiryMonth,expiryYear=:expiryYear,securityCode=:securityCode,firstName=:firstName,lastName=:lastName Where cardNumber Like :cardNumber ")
    suspend fun update(
        cardNumber: String,
        expiryMonth: String,
        expiryYear: String,
        securityCode: String,
        firstName: String,
        lastName: String
    )

//    @Query("Select * from card_details_table where cardNumber LIKE :cardNumber Limit 1 ")
//    suspend fun findByCard(cardNumber: Int): CardDetailsData?

    @Query("Select cardNumber from card_details_table ")
    suspend fun getCardNumber(): List<String>?

}