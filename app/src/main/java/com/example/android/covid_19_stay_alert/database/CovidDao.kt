package com.example.android.covid_19_stay_alert.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CovidDao {

    @Insert
    fun insert(country: Country)

    @Update
    fun update(country: Country)

    @Query("SELECT * from country_data_table WHERE countryId = :key")
    fun get(key: Int): Country?

    @Query("SELECT * FROM country_data_table ORDER BY countryId DESC")
    fun getAllCountry(): LiveData<List<Country>>

    @Query("DELETE FROM country_data_table")
    fun clear()

}