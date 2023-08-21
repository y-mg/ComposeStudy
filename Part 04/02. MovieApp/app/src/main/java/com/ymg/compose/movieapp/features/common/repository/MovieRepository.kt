package com.ymg.compose.movieapp.features.common.repository

import com.ymg.compose.movieapp.features.common.entity.CategoryEntity
import com.ymg.compose.movieapp.features.common.entity.EntityWrapper
import com.ymg.compose.movieapp.features.common.entity.MovieDetailEntity
import com.ymg.compose.movieapp.features.common.network.api.IMovieAppNetworkApi
import com.ymg.compose.movieapp.features.feed.data.FeedConstants
import com.ymg.compose.movieapp.features.feed.data.mapper.CategoryMapper
import com.ymg.compose.movieapp.features.feed.domain.enum.SortOrder
import com.ymg.compose.movieapp.library.storage.IStorage
import javax.inject.Inject


class MovieRepository @Inject constructor(
    private val movieNetworkApi: IMovieAppNetworkApi,
    private val storage: IStorage,
    private val categoryMapper: CategoryMapper
) : IMovieDataSource {
    override suspend fun getCategories(sortOrder: SortOrder?): EntityWrapper<List<CategoryEntity>> {
        return categoryMapper.mapFromResult(
            result = movieNetworkApi.getMovies(),
            extra = sortOrder
        )
    }

    override suspend fun getMovieDetail(movieName: String): MovieDetailEntity {
        return storage
            .get<List<MovieDetailEntity>>(FeedConstants.MOVIE_LIST_KEY)
            ?.single { it.title == movieName }
            ?: MovieDetailEntity()
    }
}
