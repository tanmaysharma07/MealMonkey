package com.example.mymealmonkey.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mymealmonkey.data.CardDetailsData


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

        fun getCardDetailsDatabase(context: Context): CardDetailsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CardDetailsDatabase::class.java,
                    "card_details_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}