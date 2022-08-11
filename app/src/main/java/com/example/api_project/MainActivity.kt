package com.example.api_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.api_project.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val information = arrayListOf("홈", "이벤트", "무비톡", "패스트오더", "기프트샵", "@CGV")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val mainAdapter = MainVpAdapter(this)
        binding.vpMainPage.adapter = mainAdapter
        TabLayoutMediator(binding.tbMainTable, binding.vpMainPage) {
            tab, position ->
            tab.text = information[position]
        }.attach()

        binding.ivMainMenu.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.END)
        }

    }
}