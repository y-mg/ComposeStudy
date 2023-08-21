package com.ymg.compose.restaurantapp.core.mapper

import com.ymg.compose.restaurantapp.core.entity.CategoryEntity
import com.ymg.compose.restaurantapp.core.entity.EntityWrapper
import com.ymg.compose.restaurantapp.core.entity.RestaurantDetailEntity
import com.ymg.compose.restaurantapp.core.network.model.RestaurantResponse
import com.ymg.compose.restaurantapp.libraries.storage_contract.IStorage
import com.ymg.compose.restaurantapp.libraries.storage_contract.constants.StorageKeys
import javax.inject.Inject

class CategoryMapper @Inject constructor(
    private val storage: IStorage
) : BaseMapper<List<RestaurantResponse>, List<CategoryEntity>>() {
    override fun getSuccess(
        model: List<RestaurantResponse>?,
        extra: Any?
    ): EntityWrapper.Success<List<CategoryEntity>> {
        return model?.let {
            EntityWrapper.Success(
                entity = mutableListOf<RestaurantDetailEntity>()
                    .apply {
                        addAll(model.map { item -> item.toDetailEntity() })
                    }
                    .also {
                        storage.save(StorageKeys.RESTAURANT_LIST_KEY, it)
                    }
                    .toCategoryList()
            )
        } ?: EntityWrapper.Success(
            entity = listOf()
        )
    }

    override fun getFailure(error: Throwable): EntityWrapper.Fail<List<CategoryEntity>> {
        return EntityWrapper.Fail(error)
    }
}
