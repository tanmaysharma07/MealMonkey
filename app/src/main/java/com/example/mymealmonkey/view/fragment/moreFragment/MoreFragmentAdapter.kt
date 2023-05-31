package com.example.mymealmonkey.view.fragment.moreFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymealmonkey.R
import com.example.mymealmonkey.utils.BaseItemClickListener
import com.example.mymealmonkey.utils.BaseSetOnItemClickListener

class MoreFragmentAdapter(
    private val dataset: ArrayList<MoreFragmentData>
) : RecyclerView.Adapter<MoreFragmentAdapter.ItemViewHolder>(),BaseSetOnItemClickListener {

     override lateinit var adapterClickListener: BaseItemClickListener

    override fun setOnItemClickListener(clickListener: BaseItemClickListener) {
        adapterClickListener = clickListener
    }

    class ItemViewHolder(val view: View, clickListener: BaseItemClickListener) :
        RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.more_item_image)
        val title: TextView = view.findViewById(R.id.more_item_title)

        init {
            itemView.setOnClickListener {
                clickListener.itemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoreFragmentAdapter.ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.more_fragment_item, parent, false)
        return ItemViewHolder(adapterLayout, adapterClickListener)
    }

    override fun onBindViewHolder(holder: MoreFragmentAdapter.ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.title.setText(item.titleID)
        holder.image.setImageResource(item.ImageID)
    }

    override fun getItemCount() = dataset.size
}