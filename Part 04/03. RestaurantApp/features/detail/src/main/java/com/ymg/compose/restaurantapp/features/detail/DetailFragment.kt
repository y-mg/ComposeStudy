package com.ymg.compose.restaurantapp.features.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import com.ymg.compose.restaurantapp.core.BaseFragment
import com.ymg.compose.restaurantapp.features.detail.presentation.RestaurantDetailScreen
import com.ymg.compose.restaurantapp.features.detail.presentation.output.DetailUiEffect
import com.ymg.compose.restaurantapp.features.detail.presentation.viewmodel.RestaurantDetailViewModel
import com.ymg.compose.restaurantapp.ui_components.navigation.safeNavigate
import com.ymg.compose.restaurantapp.ui_components.theme.RestaurantAppTheme

@AndroidEntryPoint
class DetailFragment : BaseFragment() {

    private val viewModel: RestaurantDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observeUiEffects()
        init()
        return ComposeView(requireContext()).apply {
            setContent {
                RestaurantAppTheme(
                    themeState = themeViewModel.themeState.collectAsState()
                ) {
                    RestaurantDetailScreen(
                        restaurantDetailState = viewModel.outputs.detailState.collectAsState(),
                        input = viewModel.inputs
                    )
                }
            }
        }
    }

    private fun init() {
        val id = arguments?.getInt("id") ?: 0
        lifecycleScope.launch {
            viewModel.initDetail(id)
        }
    }

    private fun observeUiEffects() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.outputs.detailUiEffect.collectLatest {
                    when (it) {
                        is DetailUiEffect.Back -> {
                            findNavController().safeNavigate(
                                "App://Feed"
                            )
                        }

                        is DetailUiEffect.OpenUrl -> {
                            findNavController().safeNavigate(
                                "App://Map/${it.url}"
                            )
                        }

                        is DetailUiEffect.RateRestaurant -> {
                            findNavController().safeNavigate(
                                "App://Rating/${it.restaurantName}/${it.rating}"
                            )
                        }
                    }
                }
            }
        }
    }
}
