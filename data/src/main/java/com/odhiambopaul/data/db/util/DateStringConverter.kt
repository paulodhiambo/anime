package com.odhiambopaul.data.db.util

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class DateStringConverter {
    @TypeConverter
    fun fromLong(timestamp: Long): String {
        val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            .withZone(ZoneId.systemDefault())
        return pattern.format(Instant.ofEpochMilli(timestamp))
    }

    @TypeConverter
    fun fromString(offsetDateTime: String): Long {
        val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        return LocalDateTime.parse(offsetDateTime, pattern).toInstant(ZoneOffset.ofHours(3))
            .toEpochMilli()
    }
}