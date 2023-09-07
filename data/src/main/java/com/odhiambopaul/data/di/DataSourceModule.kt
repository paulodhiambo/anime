package com.odhiambopaul.data.di

import com.odhiambopaul.data.dao.AnimeDao
import com.odhiambopaul.data.network.apis.AnimeApi
import com.odhiambopaul.data.repository.local.LocalAnimeDataSource
import com.odhiambopaul.data.repository.local.LocalAnimeDataSourceImpl
import com.odhiambopaul.data.repository.remote.RemoteTopAnimeDataSource
import com.odhiambopaul.data.repository.remote.RemoteTopAnimeDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {
    @Provides
    @Singleton
    fun provideRemoteAnimeDataSource(
        api: AnimeApi,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): RemoteTopAnimeDataSource =
        RemoteTopAnimeDataSourceImpl(
            api = api,
            ioDispatcher = ioDispatcher
        )

    @Provides
    @Singleton
    fun provideLocalAnimeDataSource(
        dao: AnimeDao,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): LocalAnimeDataSource =
        LocalAnimeDataSourceImpl(
            animeDao = dao,
            ioDispatcher = ioDispatcher
        )
}