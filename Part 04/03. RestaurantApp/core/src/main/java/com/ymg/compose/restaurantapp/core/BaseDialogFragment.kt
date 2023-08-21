package com.ymg.compose.restaurantapp.core

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.ymg.compose.restaurantapp.core.viewmodel.ThemeViewModel

open class BaseDialogFragment : DialogFragment() {
    protected val themeViewModel: ThemeViewModel by activityViewModels()
}
