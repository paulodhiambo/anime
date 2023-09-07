package com.odhiambopaul.data.repository

import com.odhiambopaul.data.network.apis.AnimeApi
import com.odhiambopaul.data.repository.local.LocalAnimeDataSource
import com.odhiambopaul.data.repository.mapper.toDomainModel
import com.odhiambopaul.domain.models.Anime
import com.odhiambopaul.domain.models.DataResult
import com.odhiambopaul.domain.models.ResourceResult
import com.odhiambopaul.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnimeManager @Inject constructor(
    private val animeApi: AnimeApi,
    private val localAnimeDataSource: LocalAnimeDataSource,
) : AnimeRepository {
    override suspend fun fetchTopAnimeRemote(): ResourceResult<List<Anime>> {
        return when (val result = animeApi.fetchTopAnime(1, 100)) {
            DataResult.Empty -> ResourceResult.Empty("Empty list ")
            is DataResult.Error -> ResourceResult.Error(result.message)
            is DataResult.Loading -> ResourceResult.Loading(true)
            is DataResult.Success -> {
                ResourceResult.Success(result.data.map { it.toDomainModel() })
            }
        }
    }

    override fun fetchTopAnime(): Flow<List<Anime>> =
        localAnimeDataSource.getCachedAnime()

    override suspend fun fetchAnimeCount(): Flow<Int> =
        localAnimeDataSource.fetchCachedAnimeCount()

    override suspend fun getAnimeById(id: Int): ResourceResult<Anime> =
        ResourceResult.Success(localAnimeDataSource.getCachedAnimeById(id))
}