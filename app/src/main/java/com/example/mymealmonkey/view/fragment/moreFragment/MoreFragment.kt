package com.example.mymealmonkey.view.fragment.moreFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentMoreBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoreFragment : Fragment() {

    // Initializing the ViewModel
    private val viewModel: MoreFragmentViewModel by viewModels()

    // Binding Component
    lateinit var binding: FragmentMoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //View Binding
        binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Array initialized
        val moreFragmentArray = ArrayList<MoreFragmentData>()
        moreFragmentArray.addAll(
            arrayOf<MoreFragmentData>(
                MoreFragmentData(
                    R.drawable._02_income,
                    getString(R.string.payment_details),
                    R.id.action_moreFragment_to_paymentDetailsFragment
                ),
                MoreFragmentData(
                    R.drawable.shopping_bag,
                    getString(R.string.my_orders),
                    R.id.action_moreFragment_to_myOrderFragment
                ),
                MoreFragmentData(
                    R.drawable.group_8081,
                    getString(R.string.notification),
                    R.id.action_moreFragment_to_notificationsFragment
                ),
                MoreFragmentData(
                    R.drawable._04_inbox_mail,
                    getString(R.string.inbox),
                    R.id.action_moreFragment_to_inboxFragment
                ),
                MoreFragmentData(
                    R.drawable._05_info,
                    getString(R.string.about_us),
                    R.id.action_moreFragment_to_aboutUsFragment
                )

            )
        )

        // Initializing RecyclerView
        val moreFragmentAdapter = MoreFragmentAdapter(this, moreFragmentArray)
        binding.recyclerViewMore.adapter = moreFragmentAdapter.apply {
            setOnItemClickListener(object : MoreFragmentAdapter.ItemClickListener {
                override fun itemClick(position: Int) {
                    findNavController().navigate(moreFragmentArray[position].navigateID)
                }
            })
        }
        binding.recyclerViewMore.hasFixedSize()
    }
}