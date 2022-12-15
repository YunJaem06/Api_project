package com.example.api_project.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    var baseUrl: String = "https://api.themoviedb.org/3/"
    var mainRetrofit = movieRetrofit()

    private fun movieRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}