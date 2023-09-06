package com.odhiambopaul.data.dao


import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.odhiambopaul.data.db.model.AnimeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimeDao : BaseDao<AnimeEntity> {
    @Query("SELECT * FROM tbl_anime")
    fun getAnime(): Flow<List<AnimeEntity>>

    @Upsert
    fun insertAnime(anime: List<AnimeEntity>)
}