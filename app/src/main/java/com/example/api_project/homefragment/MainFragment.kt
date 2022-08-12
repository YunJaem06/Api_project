package com.example.api_project.homefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.api_project.*
import com.example.api_project.moviedata.MovieJson
import com.example.api_project.moviedata.Movies
import com.example.api_project.databinding.FragmentMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

val images = arrayOf(
    R.drawable.img_ad1,
    R.drawable.img_ad2,
    R.drawable.img_ad3,
    R.drawable.img_ad4,
    R.drawable.img_ad5
)

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

        imgSliderAdapter = ImgSliderAdapter(this, images)

        setUpViewPager()

        getMovieData(getString(R.string.movie_key), "ko-KR", 1, "KR")
    }

    private fun setUpViewPager(){
        binding.vpHomeAd.adapter = imgSliderAdapter

        binding.vpHomeAd.orientation = ViewPager2.ORIENTATION_HORIZONTAL

    }

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