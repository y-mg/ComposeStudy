package com.ymg.compose.restaurantapp.features.feed.presentation.input

interface IFeedViewModelInput {
    fun openDetail(id: Int)
    fun openInfoDialog()
    fun refreshFeed()
}
