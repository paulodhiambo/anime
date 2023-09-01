package com.odhiambopaul.data.repository

import com.odhiambopaul.data.network.apis.AnimeApi
import com.odhiambopaul.data.repository.mapper.toDomain
import com.odhiambopaul.domain.model.Anime
import com.odhiambopaul.domain.model.DataResult
import com.odhiambopaul.domain.model.ResourceResult
import com.odhiambopaul.domain.repository.AnimeRepository
import javax.inject.Inject

class AnimeManager @Inject constructor(
    private val animeApi: AnimeApi
) : AnimeRepository {
    override suspend fun fetchTopAnime(): ResourceResult<List<Anime>> {
        return when (val result = animeApi.fetchTopAnime(1, 100)) {
            DataResult.Empty -> ResourceResult.Empty("Empty list ")
            is DataResult.Error -> ResourceResult.Error(result.message)
            is DataResult.Loading -> ResourceResult.Loading(true)
            is DataResult.Success -> ResourceResult.Success(result.data.map { it.toDomain() })
        }
    }
}