package com.example.api_project.homefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.api_project.databinding.FragmentGiftBinding

class GiftFragment : Fragment() {

    private lateinit var binding: FragmentGiftBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGiftBinding.inflate(inflater, container, false)
        return binding.root
    }
}