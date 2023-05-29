package com.example.mymealmonkey.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mymealmonkey.data.ProfileData

@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(profileData: ProfileData)

    @Delete
    suspend fun delete(profileData: ProfileData)

    @Query("Update profile_table Set name =:name,mobileNumber=:mobileNo,address=:address,password=:password Where email Like :email ")
    suspend fun update(name:String,email:String,mobileNo:String,address:String,password:String)

    @Query("Select * from profile_table where email LIKE :emailId Limit 1 ")
    suspend fun findByEmail(emailId:String): ProfileData?

}