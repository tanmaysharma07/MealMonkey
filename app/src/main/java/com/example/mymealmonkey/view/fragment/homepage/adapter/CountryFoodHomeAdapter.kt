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
import com.example.mymealmonkey.view.fragment.homepage.data.CountryFoodHomeData

class CountryFoodHomeAdapter(
    private val dataset: ArrayList<CountryFoodHomeData>
) : RecyclerView.Adapter<CountryFoodHomeAdapter.ItemViewHolder>(),BaseSetOnItemClickListener {

    override lateinit var adapterClickListener: BaseItemClickListener

    override fun setOnItemClickListener(clickListener: BaseItemClickListener) {
        adapterClickListener = clickListener
    }

    class ItemViewHolder(private val view: View, clickListener: BaseItemClickListener) :
        RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.country_food_home_text)
        val imageView: ImageView = view.findViewById(R.id.country_food_home_image)

        init {
            itemView.setOnClickListener {
                clickListener.itemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.country_food_home_item, parent, false)

        return ItemViewHolder(
            adapterLayout, adapterClickListener
        )
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.setText(item.nameResourceId)
        holder.imageView.setImageResource(item.imageResourcesId)
    }
}