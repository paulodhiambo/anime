package com.odhiambopaul.data.di

import com.odhiambopaul.data.work.SyncDataWorkManagerImpl
import com.odhiambopaul.domain.work.SyncDataWorkManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class WorkModule {
    @Binds
    abstract fun provideSyncDataWorkManager(impl: SyncDataWorkManagerImpl): SyncDataWorkManager
}