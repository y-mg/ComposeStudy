package com.ymg.compose.restaurantapp.core.viewmodel

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.ymg.compose.restaurantapp.libraries.storage_contract.IStorage
import com.ymg.compose.restaurantapp.libraries.storage_contract.constants.StorageKeys
import com.ymg.compose.restaurantapp.ui_components.config.ComponentConfig
import com.ymg.compose.restaurantapp.ui_components.config.DefaultComponentConfig
import com.ymg.compose.restaurantapp.ui_components.theme.color.ColorSet
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val storage: IStorage
) : ViewModel() {

    private val isDefaultThemeRed = storage.get<String>(StorageKeys.APP_THEME) == "red"

    private val _themeState: MutableStateFlow<ComponentConfig> =
        MutableStateFlow(
            if (isDefaultThemeRed) {
                DefaultComponentConfig.RED_THEME
            } else {
                DefaultComponentConfig.BLUE_THEME
            }
        )
    val themeState: StateFlow<ComponentConfig>
        get() = _themeState

    private val _nextColorState: MutableStateFlow<Color> =
        MutableStateFlow(
            if (isDefaultThemeRed) {
                DefaultComponentConfig.BLUE_THEME.colors.LightColors.primary
            } else {
                DefaultComponentConfig.RED_THEME.colors.LightColors.primary
            }
        )
    val nextColorState: StateFlow<Color>
        get() = _nextColorState

    fun toggleColorSet() {
        if (themeState.value.colors is ColorSet.Red) {
            _themeState.value = DefaultComponentConfig.BLUE_THEME
            _nextColorState.value = ColorSet.Red.LightColors.primary
        } else {
            _themeState.value = DefaultComponentConfig.RED_THEME
            _nextColorState.value = ColorSet.Blue.LightColors.primary
        }
    }

}
