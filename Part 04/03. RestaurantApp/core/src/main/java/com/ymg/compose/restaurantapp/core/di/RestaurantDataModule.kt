package com.ymg.compose.restaurantapp.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.ymg.compose.restaurantapp.core.network.api.IRestaurantAppNetworkApi
import com.ymg.compose.restaurantapp.core.network.api.RestaurantAppNetworkApi
import com.ymg.compose.restaurantapp.core.repository.IRestaurantDataSource
import com.ymg.compose.restaurantapp.core.repository.RestaurantRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RestaurantDataModule {

    @Singleton
    @Binds
    abstract fun bindRestaurantRepository(restaurantRepository: RestaurantRepository): IRestaurantDataSource

    @Singleton
    @Binds
    abstract fun bindNetwork(networkApi: RestaurantAppNetworkApi): IRestaurantAppNetworkApi

}
