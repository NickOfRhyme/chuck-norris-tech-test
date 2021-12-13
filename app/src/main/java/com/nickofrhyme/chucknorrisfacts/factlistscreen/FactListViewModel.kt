package com.nickofrhyme.chucknorrisfacts.factlistscreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nickofrhyme.chucknorrisfacts.api.ChuckNorrisAPI
import com.nickofrhyme.chucknorrisfacts.api.JokeRaw
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FactListViewModel @Inject constructor(
    private val chuckNorrisAPI: ChuckNorrisAPI
) : ViewModel() {

    private val _jokeListLD = MutableLiveData<List<String>>()
    val jokeList: LiveData<List<String>> = _jokeListLD

    init {
        getJokes(false)
    }

    fun getJokes(includeExplicit: Boolean) {
        viewModelScope.launch {
            val excludeQuery = if (includeExplicit) "[]" else "[explicit]"
            val jokes = chuckNorrisAPI.getRandomJokes(excludeQuery).value.map { it.joke }
            updateList(jokes)
        }
    }

    private fun updateList(newJokes: List<String>) {
        val newList = mutableListOf<String>()
        newList.addAll(_jokeListLD.value ?: emptyList())
        newList.addAll(newJokes)
        _jokeListLD.value = newJokes
    }
}