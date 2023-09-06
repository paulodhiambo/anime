package com.odhiambopaul.data.repository

import com.odhiambopaul.data.dao.AnimeDao
import com.odhiambopaul.data.db.model.AnimeEntity
import com.odhiambopaul.data.network.apis.AnimeApi
import com.odhiambopaul.data.repository.local.LocalAnimeDataSource
import com.odhiambopaul.data.repository.mapper.toEntity
import com.odhiambopaul.domain.models.DataResult
import com.odhiambopaul.domain.models.ResourceResult
import com.odhiambopaul.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnimeManager @Inject constructor(
    private val animeApi: AnimeApi,
    private val localAnimeDataSource: LocalAnimeDataSource,
    private val animeDao: AnimeDao
) : AnimeRepository<AnimeEntity> {
    override suspend fun fetchTopAnimeRemote(): ResourceResult<List<AnimeEntity>> {
        return when (val result = animeApi.fetchTopAnime(1, 100)) {
            DataResult.Empty -> ResourceResult.Empty("Empty list ")
            is DataResult.Error -> ResourceResult.Error(result.message)
            is DataResult.Loading -> ResourceResult.Loading(true)
            is DataResult.Success -> {
                animeDao.insertAnime(result.data.map { it.toEntity() })
                ResourceResult.Success(mutableListOf())
            }
        }
    }

    override suspend fun fetchTopAnime(): Flow<List<AnimeEntity>> =
        localAnimeDataSource.getCachedAnime()

    override suspend fun fetchAnimeCount(): Flow<Int> =
        localAnimeDataSource.fetchCachedAnimeCount()

    override suspend fun getAnimeById(id: Int): ResourceResult<AnimeEntity> =
        ResourceResult.Success(localAnimeDataSource.getCachedAnimeById(id))
}