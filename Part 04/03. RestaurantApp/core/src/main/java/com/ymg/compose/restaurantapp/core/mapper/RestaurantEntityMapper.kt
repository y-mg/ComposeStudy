package com.ymg.compose.restaurantapp.core.mapper

import com.ymg.compose.restaurantapp.core.entity.CategoryEntity
import com.ymg.compose.restaurantapp.core.entity.RestaurantDetailEntity
import com.ymg.compose.restaurantapp.core.entity.RestaurantFeedItemEntity
import com.ymg.compose.restaurantapp.core.network.model.RestaurantResponse

fun RestaurantResponse.toDetailEntity(): RestaurantDetailEntity = RestaurantDetailEntity(
    id = this.id,
    latlng = this.latlng.toEntity(),
    cuisineType = this.cuisineType,
    address = this.address,
    operatingHours = this.operatingHours.toEntity(),
    reviews = this.reviews.map { it.toEntity() },
    neighborhood = this.neighborhood,
    name = this.name,
    photograph = this.photograph,
    rating = this.reviews.map { it.rating }.average().toFloat()
)

fun RestaurantResponse.LatLngResponse.toEntity(): RestaurantDetailEntity.LatLngEntity =
    com.ymg.compose.restaurantapp.core.entity.RestaurantDetailEntity.LatLngEntity(
        lat = this.lat,
        lng = this.lng
    )

fun RestaurantResponse.OperatingHoursResponse.toEntity(): RestaurantDetailEntity.OperatingHoursEntity =
    com.ymg.compose.restaurantapp.core.entity.RestaurantDetailEntity.OperatingHoursEntity(
        monday = this.monday,
        tuesday = this.tuesday,
        wednesday = this.wednesday,
        thursday = this.thursday,
        friday = this.friday,
        saturday = this.saturday,
        sunday = this.sunday
    )

fun RestaurantResponse.ReviewResponse.toEntity(): RestaurantDetailEntity.ReviewEntity =
    com.ymg.compose.restaurantapp.core.entity.RestaurantDetailEntity.ReviewEntity(
        name = this.name,
        date = this.date,
        rating = this.rating,
        comments = this.comments
    )

fun List<RestaurantFeedItemEntity>.toCategoryList(): List<CategoryEntity> {
    val feedList = this
    val neighborhoodSet = map { it.neighborhood }.toSet()

    return mutableListOf<CategoryEntity>().also { feedItems ->
        neighborhoodSet.forEachIndexed { index, neighborhoodName ->
            feedList
                .filter { it.neighborhood == neighborhoodName }
                .sortedByDescending { it.rating }
                .let {
                    feedItems.add(
                        CategoryEntity(
                            id = index,
                            neighborhood = neighborhoodName,
                            feedEntities = it
                        )
                    )
                }
        }
    }
}
