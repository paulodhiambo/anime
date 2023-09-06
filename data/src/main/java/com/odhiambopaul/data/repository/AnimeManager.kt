package com.odhiambopaul.data.repository

import com.odhiambopaul.data.dao.AnimeDao
import com.odhiambopaul.data.network.apis.AnimeApi
import com.odhiambopaul.data.repository.local.LocalAnimeDataSource
import com.odhiambopaul.data.repository.mapper.toDomain
import com.odhiambopaul.data.repository.mapper.toEntity
import com.odhiambopaul.domain.model.Anime
import com.odhiambopaul.domain.model.DataResult
import com.odhiambopaul.domain.model.ResourceResult
import com.odhiambopaul.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnimeManager @Inject constructor(
    private val animeApi: AnimeApi,
    private val localAnimeDataSource: LocalAnimeDataSource,
    private val animeDao: AnimeDao
) : AnimeRepository {
    override suspend fun fetchTopAnime(): ResourceResult<List<Anime>> {
        return when (val result = animeApi.fetchTopAnime(1, 100)) {
            DataResult.Empty -> ResourceResult.Empty("Empty list ")
            is DataResult.Error -> ResourceResult.Error(result.message)
            is DataResult.Loading -> ResourceResult.Loading(true)
            is DataResult.Success -> {
                val anime = animeDao.insertAnime(result.data.map { it.toEntity() })
                ResourceResult.Success(anime.map { it.toDomain() })
            }
        }
    }

    override suspend fun fetchAnimeCount(): Flow<Int> =
        localAnimeDataSource.fetchCachedAnimeCount()

    override suspend fun getAnimeById(id: Int): ResourceResult<Anime> =
        ResourceResult.Success(localAnimeDataSource.getCachedAnimeById(id)?.toDomain())
}