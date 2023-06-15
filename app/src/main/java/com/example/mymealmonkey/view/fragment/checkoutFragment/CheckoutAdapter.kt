package com.example.mymealmonkey.view.fragment.checkoutFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymealmonkey.R
import com.example.mymealmonkey.utils.BaseItemClickListener
import com.example.mymealmonkey.utils.BaseSetOnItemClickListener

class CheckoutAdapter(
    val dataset: ArrayList<CheckoutData>
) : RecyclerView.Adapter<CheckoutAdapter.ItemViewHolder>(), BaseSetOnItemClickListener {

    override lateinit var adapterClickListener: BaseItemClickListener

    override fun setOnItemClickListener(clickListener: BaseItemClickListener) {
        adapterClickListener = clickListener
    }

    class ItemViewHolder(private val view: View, clickListener: BaseItemClickListener) :
        RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.titleCheckoutRV)
        val image: ImageView = view.findViewById(R.id.imageCheckoutRV)
        val button: CheckBox = view.findViewById(R.id.checkoutRadioButtonRV)

        init {
            itemView.setOnClickListener {
                clickListener.itemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.checkout_fragment_item, parent, false)
        return ItemViewHolder(adapterLayout, adapterClickListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.title.setText(item.titleId)
        holder.image.setImageResource(item.imageId)
    }

    override fun getItemCount() = dataset.size
}

