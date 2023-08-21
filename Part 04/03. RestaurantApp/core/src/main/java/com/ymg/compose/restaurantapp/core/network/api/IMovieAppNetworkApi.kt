package com.ymg.compose.restaurantapp.core.network.api

import com.ymg.compose.restaurantapp.core.network.model.RestaurantResponse
import com.ymg.compose.restaurantapp.libraries.network_contract.model.ApiResult

interface IRestaurantAppNetworkApi {
    suspend fun getRestaurantsList(): ApiResult<List<RestaurantResponse>>
}
