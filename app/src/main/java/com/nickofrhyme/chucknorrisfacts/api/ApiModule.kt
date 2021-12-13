package com.nickofrhyme.chucknorrisfacts.api

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val client = OkHttpClient()

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun chuckNorrisAPI(retrofit: Retrofit) = retrofit.create(ChuckNorrisAPI::class.java)

    @Provides
    fun retrofit() = Retrofit.Builder()
        .baseUrl("http://api.icndb.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}