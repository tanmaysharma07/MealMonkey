package com.example.mymealmonkey.view.fragment.checkoutFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymealmonkey.R

class CheckoutAdapter(
    val context: CheckoutFragment,
    val dataset: List<CheckoutData>
) : RecyclerView.Adapter<CheckoutAdapter.ItemViewHolder>() {

    private var selectedPosition = -1

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.titleCheckoutRV)
        val image: ImageView = view.findViewById(R.id.imageCheckoutRV)
        val button: Button = view.findViewById(R.id.checkoutRadioButtonRV)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.checkout_fragment_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.title.text = context.resources.getString(item.titleId)
        holder.image.setImageResource(item.imageId)

        holder.itemView.setOnClickListener{
            holder.button.isPressed
        }
    }

    override fun getItemCount() = dataset.size

     fun onItemClick(holder: RecyclerView.ViewHolder, position: Int) {
        // Set the current item as the selected item.
        selectedPosition = position
        notifyDataSetChanged()
    }

}

