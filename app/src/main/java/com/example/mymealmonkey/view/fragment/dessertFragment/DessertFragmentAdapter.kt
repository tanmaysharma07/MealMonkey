package com.example.mymealmonkey.view.fragment.dessertFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymealmonkey.R

class DessertFragmentAdapter(
    private val context: DessertFragment,
    private val dataset: List<DessertFragmentData>
):RecyclerView.Adapter<DessertFragmentAdapter.ItemHolder>() {
    class ItemHolder(private val view: View):RecyclerView.ViewHolder(view) {
        val image:ImageView = view.findViewById(R.id.dessert_fragment_image)
        val dish:TextView = view.findViewById(R.id.dessert_fragment_dish)
        val rating:TextView = view.findViewById(R.id.dessert_fragment_rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.desserts_page_item,parent,false)
        return ItemHolder(adapterLayout)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = dataset[position]
        holder.dish.text = context.resources.getString(item.dishId)
        holder.rating.text = context.resources.getString(item.ratingId)
        holder.image.setImageResource(item.imageId)
    }
}