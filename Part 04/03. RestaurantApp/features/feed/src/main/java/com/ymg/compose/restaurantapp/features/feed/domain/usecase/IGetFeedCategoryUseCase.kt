package com.ymg.compose.restaurantapp.features.feed.domain.usecase

import com.ymg.compose.restaurantapp.core.entity.CategoryEntity
import com.ymg.compose.restaurantapp.core.entity.EntityWrapper

interface IGetFeedCategoryUseCase {
    suspend operator fun invoke(): EntityWrapper<List<CategoryEntity>>
}
