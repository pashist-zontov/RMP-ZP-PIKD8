package ru.fefu.helloworld

import androidx.room.TypeConverter
import java.util.*

class DateConverter {
    @TypeConverter
    fun TimeFromDate(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun DateFromTime(milliseconds: Long?): Date? {
        return milliseconds?.let { Date(it) }
    }
}