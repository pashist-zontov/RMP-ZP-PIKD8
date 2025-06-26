package ru.fefu.helloworld

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DaoDBase {
    @Insert
    suspend fun insert(activityEnt: EntityActivity)

    @Query("SELECT * FROM actTypes ORDER BY startTime DESC")
    fun getAllActions() : LiveData<List<EntityActivity>>

    @Query("SELECT * FROM actTypes WHERE id = :actId")
    suspend fun getActionById(actId: Int): EntityActivity?
}