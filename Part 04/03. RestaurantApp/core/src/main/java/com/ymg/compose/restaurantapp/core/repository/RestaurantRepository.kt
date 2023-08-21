package com.ymg.compose.restaurantapp.core.repository

import com.ymg.compose.restaurantapp.core.entity.CategoryEntity
import com.ymg.compose.restaurantapp.core.entity.EntityWrapper
import com.ymg.compose.restaurantapp.core.entity.RestaurantDetailEntity
import com.ymg.compose.restaurantapp.core.mapper.CategoryMapper
import com.ymg.compose.restaurantapp.core.network.api.IRestaurantAppNetworkApi
import com.ymg.compose.restaurantapp.libraries.storage_contract.IStorage
import com.ymg.compose.restaurantapp.libraries.storage_contract.constants.StorageKeys
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val restaurantNetworkApi: IRestaurantAppNetworkApi,
    private val storage: IStorage,
    private val categoryMapper: CategoryMapper
) : IRestaurantDataSource {
    override suspend fun getCategories(): EntityWrapper<List<CategoryEntity>> {
        return categoryMapper.mapFromResult(
            result = restaurantNetworkApi.getRestaurantsList()
        )
    }

    override suspend fun getRestaurantDetail(id: Int): RestaurantDetailEntity {
        return storage
            .get<List<RestaurantDetailEntity>>(StorageKeys.RESTAURANT_LIST_KEY)
            ?.single { it.id == id }
            ?: RestaurantDetailEntity()
    }
}
