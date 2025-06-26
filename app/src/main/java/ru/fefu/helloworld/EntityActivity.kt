package ru.fefu.helloworld

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.util.*

@Entity(tableName = "actTypes")
data class EntityActivity (

    @PrimaryKey (autoGenerate = true) val id: Int = 0,
    val spType: ActType,
    val startTime: Date,
    val endTime: Date,
    val distance: Double
) {
    enum class ActType {
        WALKING, RUNNING, BIKING;

        companion object {
            @TypeConverter
            @JvmStatic
            fun fromString(value: String?): ActType? {
                return value?.let { enumValueOf<ActType>(it) }
            }

            @TypeConverter
            @JvmStatic
            fun toString(type: ActType?): String? {
                return type?.name
            }
        }
    }

}