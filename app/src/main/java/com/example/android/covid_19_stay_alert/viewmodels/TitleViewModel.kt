package com.example.android.covid_19_stay_alert.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.android.covid_19_stay_alert.database.CovidDao
import timber.log.Timber

class TitleViewModel (datasource: CovidDao, application: Application): ViewModel() {

    val database = datasource
    val countries= database.getAllCountry()

//    val countries = mutableListOf(
//        "China",
//        "Italy",
//        "USA",
//        "Germany",
//        "Brazil",
//        "Sweden",
//        "Spain",
//        "France",
//        "UK",
//        "Austria",
//        "Iran",
//        "Egypt",
//        "India",
//        "Switzerland",
//        "Mexico",
//        "Canada"
//    )

   // private var countries: MutableList<String>
    val countryCodeTest = 11

    init {
        Timber.i("TitleViewModel created!")

    }

    //Just for now, this will be changed
    override fun onCleared() {
        super.onCleared()
        Timber.i("TitleViewModel destroyed!")
    }
}