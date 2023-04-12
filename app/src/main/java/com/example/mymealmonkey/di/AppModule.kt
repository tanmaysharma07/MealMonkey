package com.example.mymealmonkey.di

import android.content.Context
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
    fun eventListener():EventListener{
        return EventListener()
    }
}