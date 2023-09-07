package com.odhiambopaul.domain.repository


import com.odhiambopaul.domain.models.Anime
import com.odhiambopaul.domain.models.ResourceResult
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {
    suspend fun fetchTopAnimeRemote(): ResourceResult<List<Anime>>
    fun fetchTopAnime(): Flow<List<Anime>>
    suspend fun fetchAnimeCount(): Flow<Int>
    suspend fun getAnimeById(id: Int): ResourceResult<Anime>
}