package com.ymg.compose.restaurantapp.features.detail.domain.usecase

import com.ymg.compose.restaurantapp.core.entity.RestaurantDetailEntity

interface IGetRestaurantDetailUseCase {
    suspend operator fun invoke(id: Int): RestaurantDetailEntity
}
