package com.ymg.compose.movieapp.features.detail.presentation.output

import com.ymg.compose.movieapp.features.common.entity.MovieDetailEntity


sealed class MovieDetailState {
    object Initial : MovieDetailState()
    class Main(val movieDetailEntity: MovieDetailEntity) : MovieDetailState()
}
