package com.odhiambopaul.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.odhiambopaul.data.dao.AnimeDao
import com.odhiambopaul.data.db.model.AnimeEntity
import com.odhiambopaul.data.db.util.InstantConverter

@Database(
    entities = [
        AnimeEntity::class
    ],
    version = 1,
    exportSchema = false,
)
@TypeConverters(
    InstantConverter::class
)
abstract class AnimeDatabase : RoomDatabase() {
    abstract fun animeDao(): AnimeDao
}