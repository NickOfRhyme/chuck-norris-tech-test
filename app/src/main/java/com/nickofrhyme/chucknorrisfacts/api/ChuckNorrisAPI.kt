package com.nickofrhyme.chucknorrisfacts.api

import retrofit2.http.GET

interface ChuckNorrisAPI {

    @GET("jokes/random")
    suspend fun getRandomJoke(): JokeRaw

}