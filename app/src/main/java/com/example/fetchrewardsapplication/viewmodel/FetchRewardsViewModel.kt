package com.example.fetchrewardsapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchrewardsapplication.model.FetchRewardsModel
import com.example.fetchrewardsapplication.repository.FetchRewardsRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class FetchRewardsViewModel(private val fetchRewardsRepository: FetchRewardsRepository) :
    ViewModel() {

    var myCustomPosts: MutableLiveData<Response<List<FetchRewardsModel>>> = MutableLiveData()

    /**
     * Launches a new coroutine without blocking the current thread and returns a reference to the coroutine as a Job. The coroutine is cancelled when the resulting job is cancelled.
     *
     */
    fun getFetchRewardsData() {
        viewModelScope.launch {
            val response = fetchRewardsRepository.getFetchRewardsData()
            myCustomPosts.value = response
        }
    }
}