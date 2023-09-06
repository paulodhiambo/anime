package com.odhiambopaul.data.repository.mapper

import com.odhiambopaul.data.db.model.AnimeEntity
import com.odhiambopaul.data.network.model.responses.AnimeDto
import com.odhiambopaul.domain.model.Anime

fun AnimeDto.toEntity() = AnimeEntity(
    id = 0,
    airing = airing,
    approved = approved,
    background = background,
    duration = duration,
    episodes = episodes,
    favorites = favorites,
    smallImage = images.jpg.small_image_url,
    largeImage = images.jpg.large_image_url,
    malId = mal_id,
    members = members,
    popularity = popularity,
    rank = rank,
    rating = rating,
    score = score,
    scoredBy = scored_by,
    season = season,
    source = source,
    status = status,
    synopsis = synopsis,
    title = title,
    titleEnglish = title_english,
    embedUrl = trailer.embed_url,
    trailerUrl = trailer.youtube_id,
    type = type,
    url = url,
    year = year
)

fun AnimeEntity.toDomain() = Anime(
    id = 0,
    airing = airing,
    approved = approved,
    background = background,
    duration = duration,
    episodes = episodes,
    favorites = favorites,
    smallImage = smallImage,
    largeImage = largeImage,
    malId = malId,
    members = members,
    popularity = popularity,
    rank = rank,
    rating = rating,
    score = score,
    scoredBy = scoredBy,
    season = season,
    source = source,
    status = status,
    synopsis = synopsis,
    title = title,
    titleEnglish = title,
    embedUrl = embedUrl,
    trailerUrl = trailerUrl,
    type = type,
    url = url,
    year = year
)