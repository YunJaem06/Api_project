package com.example.api_project.utils

import android.app.Application
import com.example.api_project.R
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, getString(R.string.kakao_key))
    }
}