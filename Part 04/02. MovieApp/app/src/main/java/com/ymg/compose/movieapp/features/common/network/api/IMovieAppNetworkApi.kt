package com.ymg.compose.movieapp.features.common.network.api

import com.ymg.compose.movieapp.features.common.network.model.MovieResponse
import com.ymg.compose.movieapp.library.network.model.ApiResult


interface IMovieAppNetworkApi {
    suspend fun getMovies(): ApiResult<List<MovieResponse>>
}
