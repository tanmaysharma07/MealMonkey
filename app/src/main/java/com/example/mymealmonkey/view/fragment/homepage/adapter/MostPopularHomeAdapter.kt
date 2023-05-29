package com.example.mymealmonkey.view.fragment.homepage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymealmonkey.R
import com.example.mymealmonkey.view.fragment.homepage.data.MostPopularHomeData

class MostPopularHomeAdapter(
    val context: com.example.mymealmonkey.view.fragment.homepage.HomePageFragment,
    private val dataset: List<MostPopularHomeData>
) : RecyclerView.Adapter<MostPopularHomeAdapter.ItemViewHolder>() {

    private lateinit var adapterClickListener: ItemClickListener

    interface ItemClickListener {
        fun itemClick(position: Int)
    }

    fun setOnItemClickListener(clickListener: ItemClickListener) {
        adapterClickListener = clickListener
    }

    class ItemViewHolder(val view: View, clickListener: ItemClickListener) :
        RecyclerView.ViewHolder(view) {
        val dish: TextView = view.findViewById(R.id.most_popular_home_dish)
        val type: TextView = view.findViewById(R.id.most_popular_home_type)
        val imageView: ImageView = view.findViewById(R.id.most_popular_home_image)

        init {
            itemView.setOnClickListener {
                clickListener.itemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.most_popular_home_item, parent, false)
        return ItemViewHolder(adapterLayout, adapterClickListener)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.dish.text = context.resources.getString(item.nameResourceId)
        holder.type.text = context.resources.getString(item.typeResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }
}