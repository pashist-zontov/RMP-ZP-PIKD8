package ru.fefu.helloworld

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "actTypes")
data class EntityActivity (
    @PrimaryKey (autoGenerate = true) val id: Int = 0,
    val spType: ActType,
    val startTime: Date,
    val endTime: Date,
    val distance: Double
) {
    enum class ActType (
        WALKING, RUNNING, BIKING
    )

}