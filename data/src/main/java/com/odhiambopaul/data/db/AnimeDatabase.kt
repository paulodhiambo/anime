package com.odhiambopaul.data.db

import androidx.room.AutoMigration
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
    version = 2,
    exportSchema = true,
    autoMigrations = [AutoMigration(from = 1, to = 2)]
)
@TypeConverters(
    InstantConverter::class
)
abstract class AnimeDatabase : RoomDatabase() {
    abstract fun sessionDao(): AnimeDao
}