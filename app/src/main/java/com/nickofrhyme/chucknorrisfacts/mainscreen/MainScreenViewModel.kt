package com.nickofrhyme.chucknorrisfacts.mainscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor() : ViewModel() {

    private val _includeExplicit = MutableLiveData(true)
    val includeExplicit: LiveData<Boolean> = _includeExplicit

    fun toggleExplicit(isChecked: Boolean) {
        _includeExplicit.value = (isChecked)
    }

}