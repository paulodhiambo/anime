package com.odhiambopaul.data.di

import com.odhiambopaul.data.dao.AnimeDao
import com.odhiambopaul.data.db.AnimeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Provides
    @Singleton
    fun provideAnimeDao(
        database: AnimeDatabase
    ): AnimeDao = database.sessionDao()
}