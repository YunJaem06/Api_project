package com.example.api_project.utils.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.api_project.ui.*
import com.example.api_project.ui.home.MainFragment
import com.example.api_project.ui.user.MainActivity

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