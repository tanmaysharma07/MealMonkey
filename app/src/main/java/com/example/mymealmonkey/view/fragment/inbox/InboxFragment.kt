package com.example.mymealmonkey.view.fragment.inbox

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymealmonkey.databinding.FragmentInboxBinding

class InboxFragment : Fragment() {

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

        // Initialized RecyclerView
        val inboxDataset = InboxDatasource().loadInbox()
        binding.inboxRecyclerView.adapter = InboxAdapter(this, inboxDataset)
        binding.inboxRecyclerView.hasFixedSize()
    }
}