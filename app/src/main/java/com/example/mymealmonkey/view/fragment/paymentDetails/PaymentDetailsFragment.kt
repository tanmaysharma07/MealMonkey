package com.example.mymealmonkey.view.fragment.paymentDetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.data.CardDetailsData
import com.example.mymealmonkey.databinding.FragmentPaymentDetailsBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import java.util.Calendar

@AndroidEntryPoint
class PaymentDetailsFragment : Fragment() {

    // Binding Components
    lateinit var binding: FragmentPaymentDetailsBinding

    private val viewModel: PaymentDetailsFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //View Binding
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_payment_details, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val calendar: Calendar = Calendar.getInstance()
        var userList = viewModel.paymentDetails.value ?: ArrayList()

        if (viewModel.paymentDetailsFragmentAdapter == null) {
            viewModel.paymentDetailsFragmentAdapter =
                PaymentDetailsFragmentAdapter(
                    paymentDetailUserList = viewModel.paymentDetails.value ?: userList,
                    Context = this
                )
        }

        binding.paymentdetailsRecyclerView.adapter =
            viewModel.paymentDetailsFragmentAdapter?.apply {
                setOnItemClickListener(object : PaymentDetailsFragmentAdapter.ItemClickListener {
                    override fun itemClick(position: Int) {
                        userList.removeAt(position)
                        notifyItemRemoved(position)
                        notifyItemRangeRemoved(0, userList.size)
                        eventListener?.list = userList

                        runBlocking {
                            val list = appPreferences?.getCardNumber()
                            Log.d("HOHO", list?.get(position).toString())
                            appPreferences?.deleteCardNumber(list?.get(position) ?: "")
                        }
                    }
                })
            }
        binding.paymentdetailsRecyclerView.hasFixedSize()


        //Inflate Bottom Sheet on Click of Button
        binding.addCardButtonPaymentDetails.setOnClickListener {
            val dialog = BottomSheetDialog(requireContext())
            val view = layoutInflater.inflate(R.layout.payment_detail_bottom_sheet, null)
            val closeButton = view.findViewById<ImageView>(R.id.notification_bottom_sheet_close)
            val addButton = view.findViewById<Button>(R.id.add_card)
            val cardNumber = view.findViewById<TextInputLayout>(R.id.cardNumber)
            val cardMonth = view.findViewById<TextInputLayout>(R.id.cardMonth)
            val cardYear = view.findViewById<TextInputLayout>(R.id.cardYear)
            val cardSecurityCode = view.findViewById<TextInputLayout>(R.id.cardSecurityCode)
            val cardFirstName = view.findViewById<TextInputLayout>(R.id.cardFirstName)
            val cardLastName = view.findViewById<TextInputLayout>(R.id.cardLastName)

            closeButton.setOnClickListener {
                dialog.dismiss()
            }

            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()

            addButton.setOnClickListener {

                if (cardNumber.editText?.text.toString().length != 16) {
                    cardNumber.helperText = "Invalid Card Number"
                    return@setOnClickListener
                }
                cardNumber.helperText = null

                if (((cardMonth.editText?.text?.toString()?.toIntOrNull()
                        ?: 0) > 12) || (cardMonth.editText?.text?.toString()?.toIntOrNull()
                        ?: 0) < 1
                ) {
                    cardMonth.helperText = "Invalid Month"
                    return@setOnClickListener
                }
                cardMonth.helperText = null

                if ((cardYear.editText?.text.toString().toIntOrNull()
                        ?: 0) < calendar.get(Calendar.YEAR)
                ) {
                    cardYear.helperText = "Invalid Year"
                    return@setOnClickListener
                }
                cardYear.helperText = null

                if (cardSecurityCode.editText?.text.toString()
                        .isEmpty() || cardFirstName.editText?.text.toString()
                        .isEmpty() || cardLastName.editText?.text.toString().isEmpty()
                ) {
                    cardSecurityCode.helperText = "Invalid Code"
                    cardFirstName.helperText = "Enter First Name"
                    cardLastName.helperText = "Enter Last Name"
                    return@setOnClickListener
                }
                cardSecurityCode.helperText = null
                cardFirstName.helperText = null
                cardLastName.helperText = null

                val last4Char =
                    cardNumber.editText?.text.toString()
                        .substring((cardNumber.editText?.text?.length ?: 0) - 4)

                viewModel.addPaymentDetailsUserList(
                    resources.getString(R.string.card_star) + " $last4Char",
                    R.drawable.baseline_credit_card_svg
                )
                binding.paymentdetailsRecyclerView.adapter?.notifyItemInserted(
                    viewModel.paymentDetails.value?.size ?: 0
                )

                val cardDetails = CardDetailsData(
                    null,
                    cardNumber.editText?.text.toString(),
                    cardMonth.editText?.text.toString(),
                    cardYear.editText?.text.toString(),
                    cardSecurityCode.editText?.text.toString(),
                    cardFirstName.editText?.text.toString(),
                    cardLastName.editText?.text.toString(),

                    )
                runBlocking {
                    viewModel.setCardDetails(cardDetails)
                    viewModel.getCardNumber() ?: ArrayList()
                }
                dialog.dismiss()
            }
        }

        binding.paymentDetailsBackArrow.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
