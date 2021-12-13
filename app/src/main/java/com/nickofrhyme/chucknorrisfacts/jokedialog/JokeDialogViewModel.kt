package com.nickofrhyme.chucknorrisfacts.jokedialog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nickofrhyme.chucknorrisfacts.api.ChuckNorrisAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokeDialogViewModel @Inject constructor(
    private val chuckNorrisAPI: ChuckNorrisAPI
): ViewModel() {

    private val _joke = MutableLiveData<String>()
    val joke: LiveData<String> = _joke

    fun getJoke(includeExplicit: Boolean) {
        viewModelScope.launch {

            val apiQuery = if (includeExplicit) "[]" else "[explicit]"

            val jokeString = chuckNorrisAPI.getRandomJoke(apiQuery).value.joke
            _joke.value = jokeString
        }
    }

}