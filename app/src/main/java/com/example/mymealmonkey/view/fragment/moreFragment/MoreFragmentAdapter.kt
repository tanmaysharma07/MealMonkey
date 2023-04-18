package com.example.mymealmonkey.view.fragment.moreFragment

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mymealmonkey.R

class MoreFragmentAdapter(
    val context: MoreFragment,
    private val dataset:List<MoreFragmentData>
): RecyclerView.Adapter<MoreFragmentAdapter.ItemViewHolder>() {

    class ItemViewHolder(val view: View):RecyclerView.ViewHolder(view){
        val image:ImageView = view.findViewById(R.id.more_item_image)
        val title:TextView = view.findViewById(R.id.more_item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoreFragmentAdapter.ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.more_fragment_item,parent,false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: MoreFragmentAdapter.ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.title.text = context.resources.getString(item.titleID)
        holder.image.setImageResource(item.ImageID)
        holder.view.setOnClickListener {
            it.findNavController().navigate(item.navigateID)
        }
    }

    override fun getItemCount() = dataset.size

}