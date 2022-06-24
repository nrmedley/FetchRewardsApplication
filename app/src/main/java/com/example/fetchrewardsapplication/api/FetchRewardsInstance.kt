package com.example.fetchrewardsapplication.api

import com.example.fetchrewardsapplication.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object FetchRewardsInstance {

    /**
     * Retrofit setup, use builder to convert json to gson
     */
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * Create an implementation of the API endpoints defined by the interface
     */
    val api: FetchRewardsApi by lazy {
        retrofit.create(FetchRewardsApi::class.java)
    }

}