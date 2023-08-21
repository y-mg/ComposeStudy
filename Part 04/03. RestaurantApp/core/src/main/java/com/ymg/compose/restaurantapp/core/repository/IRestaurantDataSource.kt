package com.ymg.compose.restaurantapp.core.repository

import com.ymg.compose.restaurantapp.core.entity.CategoryEntity
import com.ymg.compose.restaurantapp.core.entity.EntityWrapper
import com.ymg.compose.restaurantapp.core.entity.RestaurantDetailEntity

interface IRestaurantDataSource {
    suspend fun getCategories(): EntityWrapper<List<CategoryEntity>>
    suspend fun getRestaurantDetail(id: Int): RestaurantDetailEntity
}
