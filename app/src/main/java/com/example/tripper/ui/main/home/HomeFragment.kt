package com.example.tripper.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tripper.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private val menu = arrayListOf(
        "최신순",
        "인기순",
        "팔로우"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val homeMenuAdapter = HomeVPAdapter(this)
        binding.homeMenuVp.adapter = homeMenuAdapter
        TabLayoutMediator(binding.homeMenuTl, binding.homeMenuVp) { tab, position ->
            tab.text = menu[position]
        }.attach()

        return binding.root
    }
}