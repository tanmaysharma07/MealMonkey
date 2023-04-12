package com.example.mymealmonkey.view.fragment.homepage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymealmonkey.R
import com.example.mymealmonkey.view.fragment.homepage.HomePageFragment
import com.example.mymealmonkey.view.fragment.homepage.data.RecentItemsHomeData

class RecentItemsHomeAdapter(
    val context: HomePageFragment,
    val dataset:List<RecentItemsHomeData>
):RecyclerView.Adapter<RecentItemsHomeAdapter.ItemViewHolder>() {
    class ItemViewHolder(val view:View): RecyclerView.ViewHolder(view) {
        val dish:TextView = view.findViewById(R.id.recent_item_home_dish)
        val type:TextView = view.findViewById(R.id.recent_item_home_type)
        val imageView: ImageView = view.findViewById(R.id.recent_item_home_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.recent_items_home_item,parent,false)
        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int  = dataset.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.dish.text = context.resources.getString(item.nameResourceId)
        holder.type.text = context.resources.getString(item.typeResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

}