package com.odhiambopaul.data.repository.mapper

import com.odhiambopaul.data.network.model.responses.AnimeDto
import com.odhiambopaul.domain.model.Anime

fun AnimeDto.toDomain() = Anime(
    airing = airing,
    approved = approved,
    background = background
)