package com.odhiambopaul.domain.repository


import com.odhiambopaul.domain.models.ResourceResult
import kotlinx.coroutines.flow.Flow

interface AnimeRepository<T> {
    suspend fun fetchTopAnimeRemote(): ResourceResult<List<T>>
    suspend fun fetchTopAnime(): Flow<List<T>>
    suspend fun fetchAnimeCount(): Flow<Int>

    suspend fun getAnimeById(id: Int): ResourceResult<T>
}