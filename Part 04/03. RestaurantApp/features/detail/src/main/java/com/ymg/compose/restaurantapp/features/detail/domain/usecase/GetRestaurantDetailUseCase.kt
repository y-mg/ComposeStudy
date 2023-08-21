package com.ymg.compose.restaurantapp.features.detail.domain.usecase

import com.ymg.compose.restaurantapp.core.entity.RestaurantDetailEntity
import com.ymg.compose.restaurantapp.core.repository.IRestaurantDataSource
import javax.inject.Inject

class GetRestaurantDetailUseCase @Inject constructor(
    private val dataSource: IRestaurantDataSource
) : IGetRestaurantDetailUseCase {
    override suspend fun invoke(id: Int): RestaurantDetailEntity {
        return dataSource.getRestaurantDetail(id)
    }
}
