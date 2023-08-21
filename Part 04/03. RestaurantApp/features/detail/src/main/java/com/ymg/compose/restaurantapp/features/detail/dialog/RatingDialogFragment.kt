package com.ymg.compose.restaurantapp.features.detail.dialog

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import dagger.hilt.android.AndroidEntryPoint
import com.ymg.compose.restaurantapp.core.BaseDialogFragment
import com.ymg.compose.restaurantapp.ui_components.R
import com.ymg.compose.restaurantapp.ui_components.components.dialog.DialogPopup
import com.ymg.compose.restaurantapp.ui_components.components.dialog.Rating
import com.ymg.compose.restaurantapp.ui_components.models.buttons.LeadingIconData
import com.ymg.compose.restaurantapp.ui_components.models.dialog.DialogButton
import com.ymg.compose.restaurantapp.ui_components.theme.RestaurantAppTheme

@AndroidEntryPoint
class RatingDialogFragment : BaseDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog?.apply {
            isCancelable = true
            setCanceledOnTouchOutside(true)
            window?.setBackgroundDrawable(ColorDrawable(requireContext().getColor(android.R.color.transparent)))
        }

        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                RestaurantAppTheme(
                    themeState = themeViewModel.themeState.collectAsState()
                ) {
                    DialogPopup.Rating(
                        restaurantName = arguments?.getString("restaurantName") ?: "",
                        rating = arguments?.getFloat("rating") ?: 0.0f,
                        buttons = listOf(
                            DialogButton.Primary(
                                title = getString(R.string.submit),
                                leadingIconData = LeadingIconData(
                                    iconDrawable = R.drawable.ic_send,
                                    iconContentDescription = R.string.submit
                                )
                            ) {
                                dismiss()
                            },
                            DialogButton.Secondary(getString(R.string.cancel)) {
                                dismiss()
                            }
                        )
                    )
                }
            }
        }
    }
}
