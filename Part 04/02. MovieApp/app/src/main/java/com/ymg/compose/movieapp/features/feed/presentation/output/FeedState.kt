package com.ymg.compose.movieapp.features.feed.presentation.output

import com.ymg.compose.movieapp.features.common.entity.CategoryEntity


sealed class FeedState {
    object Loading : FeedState()
    class Main(
        val categories: List<CategoryEntity>
    ) : FeedState()

    class Failed(
        val reason: String
    ) : FeedState()
}
