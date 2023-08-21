package com.ymg.compose.movieapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ymg.compose.movieapp.features.common.viewmodel.ThemeViewModel


open class BaseFragment : Fragment() {
    protected val themeViewModel: ThemeViewModel by activityViewModels()
}
