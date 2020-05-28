package com.example.android.covid_19_stay_alert.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Country::class], version = 1, exportSchema = false)

abstract class CovidDatabase : RoomDatabase()  {

    abstract val covidDao: CovidDao

    companion object {

        @Volatile
        private var INSTANCE: CovidDatabase? = null

        fun getInstance(context: Context): CovidDatabase {
            synchronized(this) {
                var instance =
                    INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CovidDatabase::class.java,
                        "covid_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}