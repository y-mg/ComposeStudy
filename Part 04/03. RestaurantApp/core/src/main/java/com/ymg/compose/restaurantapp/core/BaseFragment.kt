package com.ymg.compose.restaurantapp.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ymg.compose.restaurantapp.core.viewmodel.ThemeViewModel

open class BaseFragment : Fragment() {
    protected val themeViewModel: ThemeViewModel by activityViewModels()
}
