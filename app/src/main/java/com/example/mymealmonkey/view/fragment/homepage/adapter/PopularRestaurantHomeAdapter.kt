package com.example.mymealmonkey.view.fragment.homepage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymealmonkey.R
import com.example.mymealmonkey.utils.BaseItemClickListener
import com.example.mymealmonkey.utils.BaseSetOnItemClickListener
import com.example.mymealmonkey.view.fragment.homepage.data.PopularRestaurantHomeData

class PopularRestaurantHomeAdapter(
    private val dataset: ArrayList<PopularRestaurantHomeData>
) : RecyclerView.Adapter<PopularRestaurantHomeAdapter.ItemViewHolder>(),
    BaseSetOnItemClickListener {

    override lateinit var adapterClickListener: BaseItemClickListener

    override fun setOnItemClickListener(clickListener: BaseItemClickListener) {
        adapterClickListener = clickListener
    }

    class ItemViewHolder(private val view: View, clickListener: BaseItemClickListener) :
        RecyclerView.ViewHolder(view) {
        val dish: TextView = view.findViewById(R.id.popular_restaurant_dish)
        val rating: TextView = view.findViewById(R.id.popular_restaurant_rating)
        val imageView: ImageView = view.findViewById(R.id.popular_restaurant_image)

        init {
            itemView.setOnClickListener {
                clickListener.itemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.popuar_restaurant_home_item, parent, false)

        return ItemViewHolder(adapterLayout, adapterClickListener)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.imageView.setImageResource(item.imageResourceId)
        holder.dish.setText(item.nameResourceId)
        holder.rating.setText(item.ratingResourceId)

    }
}