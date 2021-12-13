package com.nickofrhyme.chucknorrisfacts

import com.nickofrhyme.chucknorrisfacts.api.ChuckNorrisAPI
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChuckNorrisRepo @Inject constructor(
    private val chuckNorrisAPI: ChuckNorrisAPI
) {
    suspend fun getJokes(includeExplicit: Boolean): List<String> {
        val excludeQuery = if (includeExplicit) "[]" else "[explicit]"
        return chuckNorrisAPI.getRandomJokes(excludeQuery).value.map { it.joke }
    }

    suspend fun getJoke(includeExplicit: Boolean): String {
        val apiQuery = if (includeExplicit) "[]" else "[explicit]"

        return chuckNorrisAPI.getRandomJoke(apiQuery).value.joke
    }
}