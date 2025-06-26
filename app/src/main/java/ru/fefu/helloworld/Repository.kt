package ru.fefu.helloworld

import androidx.lifecycle.LiveData

class Repository(private val Database: DaoDBase) {
    suspend fun insertDat(activity: EntityActivity) {
        Database.insert(activity)
    }

    fun
}