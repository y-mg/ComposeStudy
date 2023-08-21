package com.ymg.compose.movieapp.ui.config

import com.ymg.compose.movieapp.ui.theme.color.ColorSet
import com.ymg.compose.movieapp.ui.theme.Shapes
import com.ymg.compose.movieapp.ui.theme.Typography


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

