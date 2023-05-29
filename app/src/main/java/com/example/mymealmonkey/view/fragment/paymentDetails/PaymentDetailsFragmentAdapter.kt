package com.example.mymealmonkey.view.fragment.paymentDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymealmonkey.R
import com.example.mymealmonkey.utils.AppPreferences
import com.example.mymealmonkey.utils.EventListener
import javax.inject.Inject

class PaymentDetailsFragmentAdapter @Inject constructor(
    val eventListener: EventListener? = null,
    val appPreferences: AppPreferences? = null,
    private var paymentDetailUserList: ArrayList<PaymentDetailsFragmentData>,
    var Context: PaymentDetailsFragment
) : RecyclerView.Adapter<PaymentDetailsFragmentAdapter.ItemViewHolder>() {

    private lateinit var adapterClickListener: ItemClickListener

    interface ItemClickListener {
        fun itemClick(position: Int)
    }

    fun setOnItemClickListener(clickListener: ItemClickListener) {
        adapterClickListener = clickListener
    }

    class ItemViewHolder(val view: View, clickListener: ItemClickListener) :
        RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.titlePaymentDetailsRV)
        val image: ImageView = view.findViewById(R.id.imagePaymentDetailsRV)
        private val deleteButton: Button = view.findViewById(R.id.paymentDetailsButtonRV)

        init {
            deleteButton.setOnClickListener {
                clickListener.itemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PaymentDetailsFragmentAdapter.ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.payment_details_item, parent, false)
        return ItemViewHolder(adapterLayout, adapterClickListener)
    }

    override fun onBindViewHolder(
        holder: PaymentDetailsFragmentAdapter.ItemViewHolder,
        position: Int
    ) {
        val item = paymentDetailUserList[position]
        holder.title.text = (item.titleID)
        holder.image.setImageResource(item.imageId)
    }

    override fun getItemCount() = paymentDetailUserList.size
}