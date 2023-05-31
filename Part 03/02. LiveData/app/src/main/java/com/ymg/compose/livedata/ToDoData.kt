package com.ymg.compose.livedata


data class ToDoData(
    val key: Int,
    val text: String,
    val done: Boolean = false
)