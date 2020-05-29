package com.example.android.covid_19_stay_alert.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country_data_table")
data class Country(

    @PrimaryKey(autoGenerate = true)
    var countryId: Long,

    @ColumnInfo(name = "country_name")
                   var name: String,

    @ColumnInfo(name = "country_code")
                   var countryCode: String,

    @ColumnInfo(name = "country_slug")
                   var slug: String,

    @ColumnInfo(name = "country_new_confirmed_cases")
    var newConfirmed: Int,

    @ColumnInfo(name = "country_total_confirmed_cases")
                   var totalConfirmed: Int,

    @ColumnInfo(name = "country_new_deaths")
                   var newDeaths:Int,

    @ColumnInfo(name = "country_total_deaths")
                   var totalDeaths:Int,

    @ColumnInfo(name = "country_new_recovered_cases")
                   var newRecovered:Int,

    @ColumnInfo(name = "country_total_recovered_cases")
                   var totalRecovered:Int,

    @ColumnInfo(name = "date")
                   var date:String
)

{


}