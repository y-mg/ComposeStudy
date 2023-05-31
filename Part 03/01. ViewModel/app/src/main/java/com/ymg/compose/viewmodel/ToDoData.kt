package com.ymg.compose.viewmodel


data class ToDoData(
    val key: Int,
    val text: String,
    val done: Boolean = false
)
