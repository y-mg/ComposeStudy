package com.ymg.compose.restaurantapp.ui_components.config

import com.ymg.compose.restaurantapp.ui_components.theme.Shapes
import com.ymg.compose.restaurantapp.ui_components.theme.Typography
import com.ymg.compose.restaurantapp.ui_components.theme.color.ColorSet


object DefaultComponentConfig {
    val RED_THEME = ComponentConfig(
        colors = ColorSet.Red,
        shapes = Shapes,
        typography = Typography,
        isDarkTheme = false
    )

    val BLUE_THEME = ComponentConfig(
        colors = ColorSet.Blue,
        shapes = Shapes,
        typography = Typography,
        isDarkTheme = false
    )

    private var currentConfig = RED_THEME
    private var themeColorSet: ColorSet = ColorSet.Red
}

