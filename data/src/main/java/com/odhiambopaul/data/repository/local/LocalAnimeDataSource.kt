package com.odhiambopaul.data.repository.local

import com.odhiambopaul.domain.models.Anime
import kotlinx.coroutines.flow.Flow

interface LocalAnimeDataSource {

    fun getCachedAnime(): Flow<List<Anime>>

    suspend fun getCachedAnimeById(animeId: Int): Anime?

    suspend fun fetchCachedAnimeCount(): Flow<Int>

    suspend fun deleteAllCachedAnime()

    suspend fun saveCachedAnime(animes: List<Anime>)
}