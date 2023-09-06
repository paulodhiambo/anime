package com.odhiambopaul.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tbl_anime")
data class AnimeEntity(
    @PrimaryKey val id: Int,
    val airing: Boolean,
    val approved: Boolean,
    val background: String,
    val duration: String,
    val episodes: Int,
    val favorites: Int,
    val smallImage: String,
    val largeImage: String,
    val malId: Int,
    val members: Int,
    val popularity: Int,
    val rank: Int,
    val rating: String,
    val score: Double,
    val scoredBy: Int,
    val season: String,
    val source: String,
    val status: String,
    val synopsis: String,
    val title: String,
    val titleEnglish: String,
    val embedUrl:String,
    val trailerUrl:String,
    val type: String,
    val url: String,
    val year: Int
)