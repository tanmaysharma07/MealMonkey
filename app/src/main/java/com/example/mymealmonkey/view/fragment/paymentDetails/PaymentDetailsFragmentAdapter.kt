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
import com.example.mymealmonkey.utils.BaseItemClickListener
import com.example.mymealmonkey.utils.BaseSetOnItemClickListener
import com.example.mymealmonkey.utils.EventListener
import javax.inject.Inject

class PaymentDetailsFragmentAdapter @Inject constructor(
    val eventListener: EventListener? = null,
    val appPreferences: AppPreferences? = null,
    private var paymentDetailUserList: ArrayList<PaymentDetailsFragmentData>
) : RecyclerView.Adapter<PaymentDetailsFragmentAdapter.ItemViewHolder>(),BaseSetOnItemClickListener {

    override lateinit var adapterClickListener: BaseItemClickListener

    override fun setOnItemClickListener(clickListener: BaseItemClickListener) {
        adapterClickListener = clickListener
    }

    class ItemViewHolder(val view: View, clickListener: BaseItemClickListener) :
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
        holder.title.setText(item.titleID)
        holder.image.setImageResource(item.imageId)
    }

    override fun getItemCount() = paymentDetailUserList.size
}