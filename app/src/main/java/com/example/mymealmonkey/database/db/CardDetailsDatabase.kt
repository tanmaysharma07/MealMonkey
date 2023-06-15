package com.example.mymealmonkey.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mymealmonkey.data.CardDetailsData
import com.example.mymealmonkey.database.dao.CardDetailsDao


@Database(entities = [CardDetailsData::class], version = 1)
abstract class CardDetailsDatabase : RoomDatabase() {

    abstract fun cardDetailsDao(): CardDetailsDao

    companion object {

        private val migration_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE profile_table ALTER COLUMN mobileNumber String;")
            }
        }

        @Volatile
        private var INSTANCE: CardDetailsDatabase? = null

    }
}