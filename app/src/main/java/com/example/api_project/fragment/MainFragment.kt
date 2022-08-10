package com.example.api_project.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.api_project.*
import com.example.api_project.data.MovieJson
import com.example.api_project.data.Movies
import com.example.api_project.databinding.FragmentMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    var movieList = ArrayList<Movies>()
    private lateinit var adapter : MovieRvAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MovieRvAdapter(requireContext(), movieList)
        binding.rvMovieChart.adapter = adapter

        getMovieData(getString(R.string.movie_key), "ko-KR", 1, "KR")
    }

    private fun getMovieData(api_key: String, language: String, page: Int, region: String) {

        val movieApi = RetrofitClient.mainRetrofit.create(RetrofitMovieAPI::class.java)

        movieApi.getNowPlaying(api_key, language, page, region).enqueue(object : Callback<MovieJson> {

            override fun onResponse(call: Call<MovieJson>, response: Response<MovieJson>) {
                if (response.isSuccessful) {
                    val result = response.body() as MovieJson
                    for (i in 0..5) {
                        movieList.add(
                            Movies(
                                result.results[i].poster_path,
                                result.results[i].title,
                                result.results[i].vote_average.toString(),
                                result.results[i].getPosterPercent(),
                                result.results[i].getPopular()
                                )
                        )
                    }
                    adapter.notifyDataSetChanged()
                }
            }
            override fun onFailure(call: Call<MovieJson>, t: Throwable) {
            }
        })
    }
}