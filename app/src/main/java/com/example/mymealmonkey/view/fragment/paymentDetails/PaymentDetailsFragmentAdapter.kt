package com.example.mymealmonkey.view.fragment.paymentDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymealmonkey.R
import com.example.mymealmonkey.view.fragment.myOrder.MyOrderFragmentData
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Singleton

@Singleton
class PaymentDetailsFragmentAdapter(
    val context: PaymentDetailsFragment,
    private val dataset: List<PaymentDetailsFragmentData>
) : RecyclerView.Adapter<PaymentDetailsFragmentAdapter.ItemViewHolder>() {

    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.titlePaymentDetailsRV)
        val image: ImageView = view.findViewById(R.id.imagePaymentDetailsRV)
        val deleteButton: Button = view.findViewById(R.id.paymentDetailsButtonRV)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PaymentDetailsFragmentAdapter.ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.payment_details_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: PaymentDetailsFragmentAdapter.ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.title.text =(item.titleID)
        holder.image.setImageResource(item.imageId)
    }

    override fun getItemCount() = dataset.size
}