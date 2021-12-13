package com.nickofrhyme.chucknorrisfacts.mainscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nickofrhyme.chucknorrisfacts.api.ChuckNorrisAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokeDialogViewModel @Inject constructor(
    private val chuckNorrisAPI: ChuckNorrisAPI
): ViewModel() {

    private val _joke = MutableLiveData<String>()
    val joke: LiveData<String> = _joke

    fun getJoke() {
        viewModelScope.launch {
            val jokeString = chuckNorrisAPI.getRandomJoke().value.joke
            _joke.value = jokeString
        }
    }

}