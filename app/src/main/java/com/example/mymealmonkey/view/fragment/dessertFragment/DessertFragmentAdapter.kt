package com.example.mymealmonkey.view.fragment.dessertFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymealmonkey.R

class DessertFragmentAdapter(
    private val dataset: ArrayList<DessertFragmentData>
) : RecyclerView.Adapter<DessertFragmentAdapter.ItemHolder>() {

    private lateinit var adapterClickListener: ItemClickListener

    interface ItemClickListener {
        fun itemClick(position: Int)
    }

    fun setOnItemClickListener(clickListener: ItemClickListener) {
        adapterClickListener = clickListener
    }

    class ItemHolder(private val view: View, clickListener: ItemClickListener) :
        RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.dessert_fragment_image)
        val dish: TextView = view.findViewById(R.id.dessert_fragment_dish)
        val type: TextView = view.findViewById(R.id.dessert_fragment_type)
        val made: TextView = view.findViewById(R.id.dessert_fragment_made)

        init {
            itemView.setOnClickListener {
                clickListener.itemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.desserts_page_item, parent, false)
        return ItemHolder(adapterLayout, adapterClickListener)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = dataset[position]
        holder.dish.text = (item.dishId)
        holder.type.text = (item.typeId)
        holder.made.text = (item.madeId)
        holder.image.setImageResource(item.imageId)
    }
}