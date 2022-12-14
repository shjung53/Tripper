package com.example.tripper.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tripper.databinding.FragmentFollowingFeedBinding

class FollowingFeedFragment(): Fragment() {
    lateinit var binding: FragmentFollowingFeedBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowingFeedBinding.inflate(inflater, container, false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}