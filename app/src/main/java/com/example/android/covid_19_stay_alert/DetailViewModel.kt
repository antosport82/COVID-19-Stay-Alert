package com.example.android.covid_19_stay_alert

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber

class DetailViewModel(code: Int) : ViewModel() {

    private val _countryCode = MutableLiveData<Int>()
    val countryCode: LiveData<Int>
        get() = _countryCode

    init {
        Timber.i("CountriesViewModel created!")
        _countryCode.value = code
    }

    //Just for now, this will be changed
    override fun onCleared() {
        super.onCleared()
        Timber.i("DetailViewModel destroyed!")
    }
}

class DetailViewModelFactory(private val code: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(code) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}