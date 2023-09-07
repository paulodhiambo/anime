package com.odhiambopaul.data.repository.local

import com.odhiambopaul.data.dao.AnimeDao
import com.odhiambopaul.data.di.IoDispatcher
import com.odhiambopaul.data.repository.mapper.toDomainModel
import com.odhiambopaul.data.repository.mapper.toEntityModel
import com.odhiambopaul.domain.models.Anime
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalAnimeDataSourceImpl @Inject constructor(
    private val animeDao: AnimeDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : LocalAnimeDataSource {
    override fun getCachedAnime(): Flow<List<Anime>> = animeDao.getAnime()
        .map { speakers -> speakers.map { it.toDomainModel() } }
        .flowOn(ioDispatcher)

    override suspend fun getCachedAnimeById(animeId: Int): Anime? =
        animeDao.getAnimeById(animeId)?.toDomainModel()

    override suspend fun fetchCachedAnimeCount(): Flow<Int> = flow {
        emit(animeDao.getCount())
    }

    override suspend fun deleteAllCachedAnime() = animeDao.deleteAll()

    override suspend fun saveCachedAnime(animes: List<Anime>) =
        animeDao.insertAnime(animes.map { it.toEntityModel() })
}