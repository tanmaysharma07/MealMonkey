package com.example.mymealmonkey.view.fragment.checkoutFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentCheckoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class CheckoutFragment : Fragment() {

    val viewModel:CheckoutFragmentViewModel by viewModels()
     lateinit var binding:FragmentCheckoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCheckoutBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val checkoutDataset = CheckoutDatasource().loadCheckout()
        binding.checkoutRecyclerView.adapter = CheckoutAdapter(this,checkoutDataset)
        binding.checkoutRecyclerView.hasFixedSize()

        binding.sendOrderButtonCheckout.setOnClickListener{
            val dialog = BottomSheetDialog(requireContext())
            val view = layoutInflater.inflate(R.layout.track_order_bottom_sheet, null)
            val closeButton:ImageView = view.findViewById(R.id.trackOrderBottomSheetClose)
            closeButton.setOnClickListener {
                dialog.dismiss()
            }
            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()
        }
    }
}