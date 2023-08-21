package com.ymg.compose.restaurantapp.ui_components.navigation

import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest

fun NavController.safeNavigate(url: String) {
    currentDestination?.run {
        navigate(
            NavDeepLinkRequest.Builder
                .fromUri(url.toUri())
                .build()
        )
    }
}
