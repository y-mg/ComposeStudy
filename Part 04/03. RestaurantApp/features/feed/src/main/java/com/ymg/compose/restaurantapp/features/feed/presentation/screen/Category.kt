package com.ymg.compose.restaurantapp.features.feed.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ymg.compose.restaurantapp.core.entity.CategoryEntity
import com.ymg.compose.restaurantapp.features.feed.presentation.input.IFeedViewModelInput
import com.ymg.compose.restaurantapp.ui_components.theme.Paddings


@Composable
fun CategoryRow(
    categoryEntity: CategoryEntity,
    input: IFeedViewModelInput
) {
    Column {
        CategoryTitle(categoryEntity.neighborhood)

        LazyRow(
            contentPadding = PaddingValues(
                horizontal = Paddings.large
            )
        ) {
            itemsIndexed(categoryEntity.feedEntities) { _, item ->
                FeedItem(
                    feedItem = item,
                    input = input
                )
            }
        }
    }
}

@Composable
fun CategoryTitle(genre: String) {
    Text(
        text = genre,
        modifier = Modifier
            .padding(
                vertical = Paddings.large,
                horizontal = Paddings.extra
            ),
        style = MaterialTheme.typography.h5
    )
}
