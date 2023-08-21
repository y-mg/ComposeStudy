package com.ymg.compose.restaurantapp.features.feed.domain.usecase

import com.ymg.compose.restaurantapp.core.entity.CategoryEntity
import com.ymg.compose.restaurantapp.core.entity.EntityWrapper
import com.ymg.compose.restaurantapp.core.repository.IRestaurantDataSource
import javax.inject.Inject

class GetFeedCategoryUseCase @Inject constructor(
    private val dataSource: IRestaurantDataSource
) : IGetFeedCategoryUseCase {
    override suspend fun invoke(): EntityWrapper<List<CategoryEntity>> {
        return dataSource.getCategories()
    }
}
