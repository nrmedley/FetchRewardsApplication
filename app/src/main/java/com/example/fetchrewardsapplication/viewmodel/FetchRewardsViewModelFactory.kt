package com.example.fetchrewardsapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fetchrewardsapplication.repository.FetchRewardsRepository

/**
 * Fetch rewards view model factory
 *
 * @property fetchRewardsRepository
 * @constructor Create empty Fetch rewards view model factory
 */
@Suppress("UNCHECKED_CAST")
class FetchRewardsViewModelFactory(private val fetchRewardsRepository: FetchRewardsRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FetchRewardsViewModel(fetchRewardsRepository) as T
    }
}