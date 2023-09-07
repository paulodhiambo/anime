package com.odhiambopaul.data.di

import com.odhiambopaul.data.repository.AnimeManager
import com.odhiambopaul.domain.repository.AnimeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun provideAnimeRepo(manager: AnimeManager): AnimeRepository
}