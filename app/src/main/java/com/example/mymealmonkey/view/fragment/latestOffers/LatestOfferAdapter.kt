package com.example.mymealmonkey.view.fragment.latestOffers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymealmonkey.R
import com.example.mymealmonkey.view.fragment.homepage.data.PopularRestaurantHomeData

class LatestOfferAdapter(
    val context: LatestOffersPageFragment,
    private val dataset: List<LatestOffersData>
) : RecyclerView.Adapter<LatestOfferAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val dish: TextView = view.findViewById(R.id.latest_offers_dish)
        val rating: TextView = view.findViewById(R.id.latest_offers_rating)
        val imageView: ImageView = view.findViewById(R.id.latest_offers_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.latest_offers_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.imageView.setImageResource(item.imageResourceId)
        holder.dish.text =  context.resources.getString(item.nameResourceId)
        holder.rating.text =  context.resources.getString(item.ratingResourceId)

    }
}