package com.example.api_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.bumptech.glide.Glide
import com.example.api_project.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient

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
        binding.mainItemSlid.tvLoginBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        UserApiClient.instance.me { user, error ->
            binding.mainItemSlid.tvLoginBtn.text =  "${user?.kakaoAccount?.profile?.nickname}"
            if (user != null) {
                Glide.with(this)
                    .load(user.kakaoAccount?.profile?.profileImageUrl)
                    .into(binding.mainItemSlid.ivSideLoginProfile)
            }
        }
    }
}