package com.nickofrhyme.chucknorrisfacts.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisAPI {

    @GET("jokes/random")
    suspend fun getRandomJoke(@Query("exclude") exclude: String = "[explicit]"): JokeRaw

    @GET("jokes/random/20")
    suspend fun getRandomJokes(@Query("exclude") exclude: String = "[explicit]"): JokeListRaw

}