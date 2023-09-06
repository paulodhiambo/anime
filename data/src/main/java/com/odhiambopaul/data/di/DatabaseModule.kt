package com.odhiambopaul.data.di

import android.content.Context
import androidx.room.Room
import com.odhiambopaul.data.db.AnimeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(
        @ApplicationContext context: Context
    ): AnimeDatabase = Room.databaseBuilder(
        context,
        AnimeDatabase::class.java,
        "anime_database"
    )
        .build()
}