package com.ymg.compose.movieapp.features.detail.domain.usecase

import com.ymg.compose.movieapp.features.common.entity.MovieDetailEntity
import com.ymg.compose.movieapp.features.common.repository.IMovieDataSource
import javax.inject.Inject


class GetMovieDetailUseCase @Inject constructor(
    private val dataSource: IMovieDataSource
) : IGetMovieDetailUseCase {
    override suspend fun invoke(name: String): MovieDetailEntity {
        return dataSource.getMovieDetail(name)
    }
}
