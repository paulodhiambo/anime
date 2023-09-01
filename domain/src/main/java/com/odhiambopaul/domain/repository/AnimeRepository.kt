package com.odhiambopaul.domain.repository

import com.odhiambopaul.domain.model.Anime
import com.odhiambopaul.domain.model.ResourceResult

interface AnimeRepository {
    suspend fun fetchTopAnime(): ResourceResult<List<Anime>>
}