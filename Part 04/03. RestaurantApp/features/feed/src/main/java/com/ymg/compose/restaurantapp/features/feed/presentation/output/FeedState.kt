package com.ymg.compose.restaurantapp.features.feed.presentation.output

import com.ymg.compose.restaurantapp.core.entity.CategoryEntity


sealed class FeedState {
    object Loading : FeedState()
    class Main(
        val categories: List<CategoryEntity>
    ) : FeedState()

    class Failed(
        val reason: String
    ) : FeedState()
}
