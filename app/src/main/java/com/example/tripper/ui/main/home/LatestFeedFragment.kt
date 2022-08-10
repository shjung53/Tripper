package com.example.tripper.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tripper.databinding.FragmentLatestFeedBinding

class LatestFeedFragment: Fragment() {

    lateinit var  binding: FragmentLatestFeedBinding
    lateinit var  homeFeedRVAdapter: HomeFeedRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLatestFeedBinding.inflate(inflater, container, false)

        homeFeedRVAdapter = HomeFeedRVAdapter(requireContext())
        binding.latestFeedRv.adapter = homeFeedRVAdapter
        binding.latestFeedRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)





        return binding.root
    }
}