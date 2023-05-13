package com.example.mymealmonkey.view.fragment.inbox

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymealmonkey.R

class InboxAdapter(
    val context: InboxFragment,
    val dataset: List<InboxData>
) : RecyclerView.Adapter<InboxAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.mealmonkey_promotions)
        val titleInfo: TextView = view.findViewById(R.id.title_info)
        val date: TextView = view.findViewById(R.id.date)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.inbox_fragment_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.title.text = context.resources.getString(item.titleId)
        holder.titleInfo.text = context.resources.getString(item.titleInfoId)
        holder.date.text = context.resources.getString(item.dateId)
    }

    override fun getItemCount() = dataset.size
}