package com.nickofrhyme.chucknorrisfacts.jokedialog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nickofrhyme.chucknorrisfacts.ChuckNorrisRepo
import com.nickofrhyme.chucknorrisfacts.api.ChuckNorrisAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokeDialogViewModel @Inject constructor(
    private val chuckNorrisRepo: ChuckNorrisRepo
): ViewModel() {

    private val _joke = MutableLiveData<String>()
    val joke: LiveData<String> = _joke

    fun getJoke(includeExplicit: Boolean) {
        viewModelScope.launch {
            _joke.value = chuckNorrisRepo.getJoke(includeExplicit)
        }
    }

}