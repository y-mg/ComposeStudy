package com.ymg.compose.movieapp

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.ymg.compose.movieapp.features.common.viewmodel.ThemeViewModel


open class BaseDialogFragment : DialogFragment() {
    protected val themeViewModel: ThemeViewModel by activityViewModels()
}
