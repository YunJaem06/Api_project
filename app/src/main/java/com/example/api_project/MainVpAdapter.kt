package com.example.api_project

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.api_project.fragment.*

class MainVpAdapter(fragment: MainActivity) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int = 6

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> MainFragment()
            1 -> EventFragment()
            2 -> MovieFragment()
            3 -> OrderFragment()
            4 -> GiftFragment()
            else -> CgvFragment()
        }
    }
}