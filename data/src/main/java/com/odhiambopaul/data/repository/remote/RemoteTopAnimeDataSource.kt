package com.odhiambopaul.data.repository.remote

import com.odhiambopaul.data.di.IoDispatcher
import com.odhiambopaul.data.network.apis.AnimeApi
import com.odhiambopaul.data.network.model.responses.AnimeDto
import com.odhiambopaul.domain.models.DataResult
import com.odhiambopaul.domain.models.ResourceResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface RemoteTopAnimeDataSource {

    suspend fun getAllTopAnimeRemote(): ResourceResult<List<AnimeDto>>
}

class RemoteTopAnimeDataSourceImpl @Inject constructor(
    private val api: AnimeApi,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : RemoteTopAnimeDataSource {

    override suspend fun getAllTopAnimeRemote(): ResourceResult<List<AnimeDto>> {
        return withContext(ioDispatcher) {
            when (val response = api.fetchTopAnime()) {
                is DataResult.Success -> {
                    val anime = response.data
                    return@withContext ResourceResult.Success(data = anime)
                }

                is DataResult.Error -> {
                    return@withContext ResourceResult.Error(message = response.message)
                }

                is DataResult.Loading -> {
                    return@withContext ResourceResult.Loading()
                }

                is DataResult.Empty -> {
                    return@withContext ResourceResult.Error(message = "Anime Information not found")
                }
            }
        }
    }
}