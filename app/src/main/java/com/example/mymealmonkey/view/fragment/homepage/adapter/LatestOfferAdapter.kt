package com.example.mymealmonkey.view.fragment.homepage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymealmonkey.R
import com.example.mymealmonkey.view.fragment.homepage.data.PopularRestaurantHomeData
import com.example.mymealmonkey.view.fragment.latestOffers.LatestOffersPageFragment

class LatestOfferAdapter(
    val context: LatestOffersPageFragment,
    private val dataset:List<PopularRestaurantHomeData>
): RecyclerView.Adapter<LatestOfferAdapter.ItemViewHolder>() {

    class ItemViewHolder(val view: View):RecyclerView.ViewHolder(view){
        val dish:TextView = view.findViewById(R.id.popular_restaurant_dish)
        val type:TextView = view.findViewById(R.id.popular_restaurant_rating)
        val imageView:ImageView = view.findViewById(R.id.popular_restaurant_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.popuar_restaurant_home_item,parent,false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.dish.text = context.resources.getString(item.nameResourceId)
        holder.type.text = context.resources.getString(item.ratingResourceId)
        holder.imageView.setImageResource(item.imageResourceId)

    }

    override fun getItemCount(): Int = dataset.size

}