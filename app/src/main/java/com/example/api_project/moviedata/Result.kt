package com.example.api_project.moviedata

data class Result(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
) {
    fun getPopular(): String {
        val formatter = popularity.toInt()
        return "${formatter}만명"
    }
    fun getPosterPercent(): String {
        val percent = vote_average.toInt()
        return "${percent}%"
    }
}