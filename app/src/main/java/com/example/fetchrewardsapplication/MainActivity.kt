package com.example.fetchrewardsapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fetchrewardsapplication.adapter.FetchRewardsAdapter
import com.example.fetchrewardsapplication.repository.FetchRewardsRepository
import com.example.fetchrewardsapplication.viewmodel.FetchRewardsViewModel
import com.example.fetchrewardsapplication.viewmodel.FetchRewardsViewModelFactory
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: FetchRewardsViewModel
    private val fetchRewardsAdapter by lazy { FetchRewardsAdapter() }

    /**
     * On create
     *
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        setupRecyclerview()

        val fetchRewardsRepository = FetchRewardsRepository()
        val viewModelFactory = FetchRewardsViewModelFactory(fetchRewardsRepository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(FetchRewardsViewModel::class.java)
        viewModel.getFetchRewardsData()

        viewModel.myCustomPosts.observe(this) { response ->
            if (response.isSuccessful) {
                response.body()?.let { fetchRewardsAdapter.setData(it) }
            } else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * Setup the recyclerview
     *
     */
    private fun setupRecyclerview() {
        recyclerview.adapter=fetchRewardsAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)
    }
}
