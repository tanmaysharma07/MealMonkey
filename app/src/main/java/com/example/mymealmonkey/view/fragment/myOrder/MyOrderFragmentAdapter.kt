package com.example.mymealmonkey.view.fragment.myOrder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymealmonkey.R

class MyOrderFragmentAdapter(
    private val dataset: List<MyOrderFragmentData>
) : RecyclerView.Adapter<MyOrderFragmentAdapter.ItemViewHolder>() {

    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.veg_burger)
        val count: TextView = view.findViewById(R.id.count)
        val price: TextView = view.findViewById(R.id.price)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyOrderFragmentAdapter.ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.my_order_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: MyOrderFragmentAdapter.ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.title.setText(item.titleID)
        holder.count.setText(item.countID)
        holder.price.setText(item.priceID)
    }

    override fun getItemCount() = dataset.size
}