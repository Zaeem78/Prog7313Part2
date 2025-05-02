package com.example.budgettingapp.database.converters

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateConverter {
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    @TypeConverter
    fun toLocalDateTime(value: String): LocalDateTime {
        return LocalDateTime.parse(value, formatter)
    }

    @TypeConverter
    fun fromLocalDateTime(date: LocalDateTime): String {
        return date.format(formatter)
    }
}
