package com.example.api_project.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.api_project.databinding.FragmentCgvBinding

class CgvFragment : Fragment() {

    private lateinit var binding : FragmentCgvBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCgvBinding.inflate(inflater, container, false)
        return binding.root
    }
}