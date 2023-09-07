package com.odhiambopaul.domain.work

import kotlinx.coroutines.flow.Flow

interface SyncDataWorkManager {
    val isSyncing: Flow<Boolean>
    suspend fun startSync()
}