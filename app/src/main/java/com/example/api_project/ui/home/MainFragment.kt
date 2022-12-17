package com.example.api_project.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.api_project.*
import com.example.api_project.models.MovieJson
import com.example.api_project.models.Movies
import com.example.api_project.databinding.FragmentMainBinding
import com.example.api_project.retrofit.RetrofitClient
import com.example.api_project.retrofit.RetrofitMovieAPI
import com.example.api_project.utils.adapters.ImgSliderAdapter
import com.example.api_project.utils.adapters.MovieRvAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    var movieList = ArrayList<Movies>()
    private lateinit var adapter: MovieRvAdapter
    private lateinit var imgSliderAdapter: ImgSliderAdapter

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

        val imgUrlList = listOf(
            "https://user-images.githubusercontent.com/96619472/184324963-f75df303-4d33-46d0-b461-cec55af5f57d.png",
            "https://user-images.githubusercontent.com/96619472/184325025-7de89156-9756-4e7f-bfc8-d66d6b190fcb.png",
            "https://user-images.githubusercontent.com/96619472/184336443-d924c8bb-b96a-4379-b5fd-9b9b38973adb.png",
            "https://user-images.githubusercontent.com/96619472/184336448-aef31da8-6909-4e13-a5f4-57be532dfcf4.png",
            "https://user-images.githubusercontent.com/96619472/184336450-20f586d6-df90-4902-92ab-e8f6e79b460a.png"
        )

        imgSliderAdapter = ImgSliderAdapter(imgUrlList)

        setUpViewPager()

        getMovieData(getString(R.string.movie_key), "ko-KR", 1, "KR")
    }

    // 홈화면 광고
    private fun setUpViewPager(){
        binding.vpHomeAd.adapter = imgSliderAdapter

        binding.vpHomeAd.orientation = ViewPager2.ORIENTATION_HORIZONTAL

    }

    // api 연결
    private fun getMovieData(api_key: String, language: String, page: Int, region: String) {

        val movieApi = RetrofitClient.mainRetrofit.create(RetrofitMovieAPI::class.java)

        movieApi.getNowPlaying(api_key, language, page, region)
            .enqueue(object : Callback<MovieJson> {

                override fun onResponse(call: Call<MovieJson>, response: Response<MovieJson>) {
                    if (response.isSuccessful) {
                        val result = response.body() as MovieJson
                        for (i in 0..9) {
                            movieList.add(
                                Movies(
                                    result.results[i].poster_path,
                                    result.results[i].title,
                                    result.results[i].vote_average.toString(),
                                    result.results[i].getPosterPercent(),
                                    result.results[i].getPopular(),
                                    result.results[i].genre_ids.size
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