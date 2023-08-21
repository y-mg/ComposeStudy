package com.ymg.compose.restaurantapp.features.detail.presentation.output

import com.ymg.compose.restaurantapp.core.entity.RestaurantDetailEntity

sealed class RestaurantDetailState {
    object Initial : RestaurantDetailState()
    class Main(val detailEntity: RestaurantDetailEntity) : RestaurantDetailState()
}
