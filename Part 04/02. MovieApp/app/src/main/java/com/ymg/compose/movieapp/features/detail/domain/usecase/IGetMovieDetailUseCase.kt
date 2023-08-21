package com.ymg.compose.movieapp.features.detail.domain.usecase

import com.ymg.compose.movieapp.features.common.entity.MovieDetailEntity


interface IGetMovieDetailUseCase {
    suspend operator fun invoke(name: String): MovieDetailEntity
}
