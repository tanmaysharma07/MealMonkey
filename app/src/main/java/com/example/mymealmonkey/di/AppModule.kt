package com.example.mymealmonkey.di

import android.content.Context
import androidx.room.Room
import com.example.mymealmonkey.R
import com.example.mymealmonkey.database.db.CardDetailsDatabase
import com.example.mymealmonkey.database.db.ProfileDatabase
import com.example.mymealmonkey.utils.AppPreferences
import com.example.mymealmonkey.utils.EventListener
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext context: Context): AppPreferences {
        return AppPreferences(context)
    }

    @Singleton
    @Provides
    fun eventListener(): EventListener {
        return EventListener()
    }

    @Singleton
    @Provides
    fun profileDataRoomDB(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        ProfileDatabase::class.java,
        context.getString(R.string.profile_database)
    ).build()

    @Singleton
    @Provides
    fun cardDetailsRoomDB(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        CardDetailsDatabase::class.java,
        context.getString(R.string.card_details_database)
    ).build()

}