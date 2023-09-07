package com.odhiambopaul.data.work

import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import com.odhiambopaul.data.di.IoDispatcher
import com.odhiambopaul.data.repository.local.LocalAnimeDataSource
import com.odhiambopaul.data.repository.mapper.toDomainModel
import com.odhiambopaul.data.repository.remote.RemoteTopAnimeDataSource
import com.odhiambopaul.data.work.WorkConstants.SYNC_TITLE
import com.odhiambopaul.domain.models.ResourceResult
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import timber.log.Timber
import kotlin.random.Random

@HiltWorker
class SyncDataWorker @AssistedInject constructor(
    @Assisted val appContext: Context,
    @Assisted val workerParameters: WorkerParameters,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val remoteTopAnimeDataSource: RemoteTopAnimeDataSource,
    private val localAnimeDataSource: LocalAnimeDataSource
) : CoroutineWorker(appContext, workerParameters) {

    override suspend fun getForegroundInfo(): ForegroundInfo {
        return ForegroundInfo(
            Random.nextInt(),
            NotificationCompat.Builder(appContext, WorkConstants.NOTIFICATION_CHANNEL)
                .setSmallIcon(androidx.core.R.drawable.notification_bg_low)
                .setContentTitle(SYNC_TITLE)
                .build()

        )
    }

    override suspend fun doWork(): Result {
        withContext(ioDispatcher) {
            val animSyncDeferred = async { syncAnime() }
            animSyncDeferred.await()
        }
        return Result.success()
    }

    private suspend fun syncAnime() {
        withContext(ioDispatcher) {
            when (val response = remoteTopAnimeDataSource.getAllTopAnimeRemote()) {
                is ResourceResult.Success -> {
                    localAnimeDataSource.deleteAllCachedAnime()
                    localAnimeDataSource.saveCachedAnime(
                        animes = response.data?.map { it.toDomainModel() } ?: emptyList()
                    )
                    Timber.d("Sync anime successful")
                }

                is ResourceResult.Error -> {
                    Timber.d("Sync anime failed ${response.message}")
                }

                else -> {}
            }
        }
    }

}