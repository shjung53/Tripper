package com.example.tripper.ui.main.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

//홈 탭레이아웃 어댑터
class HomeVPAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> LatestFeedFragment()
            1 -> HotFeedFragment()
            else -> FollowingFeedFragment()
        }
    }
}