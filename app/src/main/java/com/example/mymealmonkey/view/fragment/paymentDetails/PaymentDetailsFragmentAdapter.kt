package com.example.mymealmonkey.view.fragment.paymentDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymealmonkey.R
import com.example.mymealmonkey.utils.EventListener
import javax.inject.Inject

class PaymentDetailsFragmentAdapter @Inject constructor(
    val eventListener:EventListener? = null,
    private var paymentDetailUserList: ArrayList<PaymentDetailsFragmentData>,
    var Context: PaymentDetailsFragment
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
            LayoutInflater.from(parent.context)
                .inflate(R.layout.payment_details_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(
        holder: PaymentDetailsFragmentAdapter.ItemViewHolder,
        position: Int
    ) {
        val item = paymentDetailUserList[position]
        holder.title.text = (item.titleID)
        holder.image.setImageResource(item.imageId)
        holder.deleteButton.setOnClickListener {
            paymentDetailUserList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeRemoved(0,paymentDetailUserList.size)
            eventListener?.list = paymentDetailUserList
        }
    }

    override fun getItemCount() = paymentDetailUserList.size
}