package com.example.mymealmonkey.view.fragment.notifications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymealmonkey.R

class NotificationsAdapter(
    val context: NotificationsFragment,
    val dataset: List<NotificationsData>
) : RecyclerView.Adapter<NotificationsAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.your_orders_has_been_picked_up)
        val timeAgo: TextView = view.findViewById(R.id.time_ago)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.notifications_fragment_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.title.text = context.resources.getString(item.titleId)
        holder.timeAgo.text = context.resources.getString(item.timeId)
    }

    override fun getItemCount() = dataset.size
}