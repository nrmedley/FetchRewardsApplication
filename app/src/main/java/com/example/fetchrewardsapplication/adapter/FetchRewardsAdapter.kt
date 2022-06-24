package com.example.fetchrewardsapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewardsapplication.R
import com.example.fetchrewardsapplication.model.FetchRewardsModel
import kotlinx.android.synthetic.main.fetch_rewards.view.*

class FetchRewardsAdapter : RecyclerView.Adapter<FetchRewardsAdapter.MyViewHolder>() {

    private var myList = emptyList<FetchRewardsModel>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    /**
     * On create view holder, inflate the fetch rewards xml view
     *
     * @param parent
     * @param viewType
     * @return
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fetch_rewards, parent, false)
        )
    }

    /**
     * Get item count
     *
     * @return
     */
    override fun getItemCount(): Int {
        return myList.size
    }

    /**
     * On bind view holder
     * Bind the View Holder to the lists
     * @param holder
     * @param position
     */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.tv_listId.text = myList[position].listId.toString()
        holder.itemView.tv_id.text = myList[position].id.toString()
        holder.itemView.tv_name.text = myList[position].name
    }

    /**
     * Set data
     * Filter out where name is null and sort, set the new list for the recycler view
     * @param newList
     */
    fun setData(newList: List<FetchRewardsModel>) {
        var list = newList.filter { !it.name.isNullOrEmpty() }
        list = sortList(list)
        myList = list
        notifyDataSetChanged()
    }

    /**
     * Gets the list data and sorts on the listId, then by the # in the name
     *
     * @param fetchRewardsItemList
     * @return
     */
    private fun sortList(fetchRewardsItemList: List<FetchRewardsModel>): List<FetchRewardsModel> {
        return fetchRewardsItemList.sortedWith(compareBy<FetchRewardsModel> { item ->
            item.listId
        }.thenBy { item ->
            item.name.replace("Item ", "").toInt()
        })
    }
}
