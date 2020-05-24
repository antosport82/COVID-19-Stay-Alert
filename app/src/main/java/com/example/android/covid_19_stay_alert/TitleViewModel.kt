package com.example.android.covid_19_stay_alert

import androidx.lifecycle.ViewModel
import timber.log.Timber

class TitleViewModel : ViewModel() {

    private var countries: MutableList<String>
    val countryCodeTest = 11

    init {
        Timber.i("TitleViewModel created!")
        countries = mutableListOf(
            "China",
            "Italy",
            "USA",
            "Germany",
            "Brazil",
            "Sweden",
            "Spain",
            "France",
            "UK",
            "Austria",
            "Iran",
            "Egypt",
            "India",
            "Switzerland",
            "Mexico",
            "Canada"
        )
    }

    //Just for now, this will be changed
    override fun onCleared() {
        super.onCleared()
        Timber.i("TitleViewModel destroyed!")
    }
}