package com.example.mymealmonkey.view.fragment.dessertFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymealmonkey.R
import com.example.mymealmonkey.utils.BaseSetOnItemClickListener
import com.example.mymealmonkey.utils.BaseItemClickListener

class DessertFragmentAdapter(
    private val dataset: ArrayList<DessertFragmentData>
) : RecyclerView.Adapter<DessertFragmentAdapter.ItemHolder>(), BaseSetOnItemClickListener  {

    override lateinit var adapterClickListener: BaseItemClickListener
    override fun setOnItemClickListener(clickListener: BaseItemClickListener) {
        adapterClickListener = clickListener
    }

    class ItemHolder(private val view: View, clickListener: BaseItemClickListener) :
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
        holder.dish.setText(item.dishId)
        holder.type.setText(item.typeId)
        holder.made.setText(item.madeId)
        holder.image.setImageResource(item.imageId)
    }
}