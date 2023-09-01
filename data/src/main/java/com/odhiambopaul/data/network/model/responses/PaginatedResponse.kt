package com.odhiambopaul.data.network.model.responses

data class PaginatedResponse(
    val `data`: List<AnimeDto>,
    val pagination: Pagination
)