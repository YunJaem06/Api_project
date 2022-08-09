package com.example.api_project

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitMovieAPI {

    @GET("movie/now_playing")
    fun getNowPlaying(
        @Query("api_key") api_key : String,
        @Query("language") language : String,
        @Query("page") page : Int,
        @Query("region") region: String
    ): Call<MovieJson>
}