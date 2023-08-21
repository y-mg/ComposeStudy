package com.ymg.compose.restaurantapp.core.network.api

import com.google.gson.reflect.TypeToken
import com.ymg.compose.restaurantapp.core.network.model.RestaurantResponse
import com.ymg.compose.restaurantapp.libraries.network_contract.api.NetworkRequestFactory
import com.ymg.compose.restaurantapp.libraries.network_contract.model.ApiResult
import javax.inject.Inject

class RestaurantAppNetworkApi @Inject constructor(
    private val networkRequestFactory: NetworkRequestFactory
) : IRestaurantAppNetworkApi {
    override suspend fun getRestaurantsList(): ApiResult<List<RestaurantResponse>> {
        return networkRequestFactory.create(
            url = "restaurants.json",
            type = object : TypeToken<List<RestaurantResponse>>() {}.type
        )
    }
}
