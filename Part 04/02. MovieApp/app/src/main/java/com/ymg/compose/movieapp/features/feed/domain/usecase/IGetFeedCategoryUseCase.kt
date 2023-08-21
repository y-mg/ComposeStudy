package com.ymg.compose.movieapp.features.feed.domain.usecase

import com.ymg.compose.movieapp.features.common.entity.CategoryEntity
import com.ymg.compose.movieapp.features.common.entity.EntityWrapper
import com.ymg.compose.movieapp.features.feed.domain.enum.SortOrder

interface IGetFeedCategoryUseCase {
    suspend operator fun invoke(sortOrder: SortOrder? = null): com.ymg.compose.movieapp.features.common.entity.EntityWrapper<List<com.ymg.compose.movieapp.features.common.entity.CategoryEntity>>
}
