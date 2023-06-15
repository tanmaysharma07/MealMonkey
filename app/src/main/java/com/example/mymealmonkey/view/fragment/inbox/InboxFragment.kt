package com.example.mymealmonkey.view.fragment.inbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mymealmonkey.R
import com.example.mymealmonkey.databinding.FragmentInboxBinding

class InboxFragment : Fragment() {

    //Binding Component
    lateinit var binding: FragmentInboxBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInboxBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Array to store data for Inbox
        val inboxArray = ArrayList<InboxData>()
        inboxArray.addAll(
            arrayOf(
                InboxData(
                    R.string.mealmonkey_promotions,
                    R.string.lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_sed_do_eiusmod_tempor,
                    R.string._6th_july
                ),
                InboxData(
                    R.string.mealmonkey_promotions,
                    R.string.lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_sed_do_eiusmod_tempor,
                    R.string._6th_july
                ),
                InboxData(
                    R.string.mealmonkey_promotions,
                    R.string.lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_sed_do_eiusmod_tempor,
                    R.string._6th_july
                ),
                InboxData(
                    R.string.mealmonkey_promotions,
                    R.string.lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_sed_do_eiusmod_tempor,
                    R.string._6th_july
                ),
                InboxData(
                    R.string.mealmonkey_promotions,
                    R.string.lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_sed_do_eiusmod_tempor,
                    R.string._6th_july
                ),
                InboxData(
                    R.string.mealmonkey_promotions,
                    R.string.lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_sed_do_eiusmod_tempor,
                    R.string._6th_july
                ),
                InboxData(
                    R.string.mealmonkey_promotions,
                    R.string.lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_sed_do_eiusmod_tempor,
                    R.string._6th_july
                )
            )
        )

        // Initialized RecyclerView
        binding.inboxRecyclerView.adapter = InboxAdapter(inboxArray)
        binding.inboxRecyclerView.hasFixedSize()

        clickListeners()
    }

    private fun clickListeners() {
        binding.inboxBackArrow.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}