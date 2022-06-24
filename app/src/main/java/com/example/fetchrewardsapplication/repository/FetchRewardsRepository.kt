package com.example.fetchrewardsapplication.repository

import com.example.fetchrewardsapplication.api.FetchRewardsInstance
import com.example.fetchrewardsapplication.model.FetchRewardsModel
import retrofit2.Response

class FetchRewardsRepository {

    /**
     * Get fetch rewards data from HTTP response
     *
     * @return
     */
    suspend fun getFetchRewardsData(): Response<List<FetchRewardsModel>> {
        return FetchRewardsInstance.api.getFetchRewardsData( )
    }
}