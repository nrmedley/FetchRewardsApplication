package com.example.fetchrewardsapplication.api

import com.example.fetchrewardsapplication.model.FetchRewardsModel
import retrofit2.Response
import retrofit2.http.GET

interface FetchRewardsApi {

    /**
     * Get the data from the URI
     *
     * @return
     */
    @GET("/hiring.json")
    suspend fun getFetchRewardsData(
    ): Response<List<FetchRewardsModel>>
}
