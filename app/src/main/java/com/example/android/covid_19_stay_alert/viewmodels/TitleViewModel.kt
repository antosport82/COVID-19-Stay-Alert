package com.example.android.covid_19_stay_alert.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.covid_19_stay_alert.database.CovidDao
import timber.log.Timber

class TitleViewModel(val database: CovidDao, application: Application) :
    AndroidViewModel(application) {

    //TODO for now do not use database...create a fake list of Country instances..like 4 or 5
    val countries = database.getAllCountry()

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

class TitleViewModelFactory(
    private val dataSource: CovidDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TitleViewModel::class.java)) {
            return TitleViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}