package com.ymg.compose.movieapp.features.common.repository

import com.ymg.compose.movieapp.features.common.entity.CategoryEntity
import com.ymg.compose.movieapp.features.common.entity.EntityWrapper
import com.ymg.compose.movieapp.features.common.entity.MovieDetailEntity
import com.ymg.compose.movieapp.features.feed.domain.enum.SortOrder


interface IMovieDataSource {
    suspend fun getCategories(sortOrder: SortOrder? = null): EntityWrapper<List<CategoryEntity>>
    suspend fun getMovieDetail(movieName: String): MovieDetailEntity
}
