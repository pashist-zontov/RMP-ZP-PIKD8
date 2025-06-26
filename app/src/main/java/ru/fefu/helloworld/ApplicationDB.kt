package ru.fefu.helloworld

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [EntityActivity::class], version = 2)
@TypeConverters(DateConverter::class)
abstract class ApplicationDB : RoomDatabase() {
    abstract fun DaoDatabase(): DaoDBase

    companion object {
        @Volatile
        private var INSTANCE: ApplicationDB? = null

        fun getDatabase(context: Context): ApplicationDB {
            return INSTANCE ?: synchronized(this) {
                val inst = Room.databaseBuilder(
                    context.applicationContext,
                    ApplicationDB::class.java,
                    "FEFUFit_db"
                ).build()
                INSTANCE = inst
                inst
            }
        }
    }
}