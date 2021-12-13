package com.nickofrhyme.chucknorrisfacts.mainscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.nickofrhyme.chucknorrisfacts.NavigationDispatcher
import com.nickofrhyme.chucknorrisfacts.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val navigationDispatcher: NavigationDispatcher,
) : ViewModel() {

    private val _includeExplicit = MutableLiveData(true)
    val includeExplicit: LiveData<Boolean> = _includeExplicit

    fun toggleExplicit(isChecked: Boolean) {
        _includeExplicit.value = (isChecked)
    }

    fun navigateToJokeList() {
        navigationDispatcher.emit {  navController: NavController ->
            navController.navigate(R.id.factListScreen)
        }
    }
}