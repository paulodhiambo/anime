package com.odhiambopaul.domain.repository

import com.odhiambopaul.domain.model.Anime
import com.odhiambopaul.domain.model.ResourceResult
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {
    suspend fun fetchTopAnime(): ResourceResult<List<Anime>>

    suspend fun fetchAnimeCount(): Flow<Int>

    suspend fun getAnimeById(id: Int): ResourceResult<Anime>
}