package com.odhiambopaul.data.repository.local

import com.odhiambopaul.data.db.model.AnimeEntity
import kotlinx.coroutines.flow.Flow

interface LocalAnimeDataSource {

    fun getCachedAnime(): Flow<List<AnimeEntity>>

    suspend fun getCachedAnimeById(speakerId: Int): AnimeEntity?

    fun fetchCachedAnimeCount(): Flow<Int>

    suspend fun deleteAllCachedAnime()

    suspend fun saveCachedAnime(speakers: List<AnimeEntity>)
}