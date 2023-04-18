package com.example.mymealmonkey.view.fragment.menuFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymealmonkey.R
import com.example.mymealmonkey.view.fragment.dessertFragment.DessertFragment
import com.example.mymealmonkey.view.fragment.dessertFragment.DessertFragmentData

class MenuFragmentAdapter(
    val context: MenuFragment,
    val dataset: List<MenuFragmentData>
):RecyclerView.Adapter<MenuFragmentAdapter.ItemHolder>() {
    class ItemHolder(private val view: View):RecyclerView.ViewHolder(view) {
        val image:ImageView = view.findViewById(R.id.dessert_fragment_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.desserts_page_item,parent,false)
        return ItemHolder(adapterLayout)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = dataset[position]
        holder.image.setImageResource(item.imageId)
    }
}