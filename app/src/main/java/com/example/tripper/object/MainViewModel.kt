package com.example.tripper.`object`

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel: ViewModel() {
    private val _datesData = MutableLiveData<ArrayList<Date>>()
    val datesData: LiveData<ArrayList<Date>> get() = _datesData

    fun getDates(datesData: ArrayList<Date>){
        _datesData.value = datesData
    }
}