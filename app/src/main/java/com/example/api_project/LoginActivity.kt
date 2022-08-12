package com.example.api_project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.api_project.databinding.ActivityLoginBinding
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivKakaoLogin.setOnClickListener {
            kakaoLogin()
        }

        binding.ivKakaoLogout.setOnClickListener {
            UserApiClient.instance.logout { error ->
                if (error!=null){
                    Log.d("logout-fail", "카카오계정으로 로그아웃 실패 : ${error}")
                } else{
                    Toast.makeText(this, "로그아웃 성공", Toast.LENGTH_SHORT).show()
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
    private fun kakaoLogin(){
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null){
                // 로그인 실패
                Log.d("login-fail", "카카오계정으로 로그인 실패 : ${error}")
            } else if (token != null){
                UserApiClient.instance.me { user, error ->
                    // 로그인 성공
                    Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                    Log.d("login-success ", "카카오계정으로 로그인 성공 : ${token.accessToken}")
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
            UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
                if (error != null){
                    Log.d("login-fail", "카카오계정으로 로그인 실패 : ${error}")

                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled){
                        return@loginWithKakaoTalk
                    }
                    UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
                } else if (token != null){
                    Log.d("login-success ", "카카오계정으로 로그인 성공 : ${token.accessToken}")
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
        }
    }
}