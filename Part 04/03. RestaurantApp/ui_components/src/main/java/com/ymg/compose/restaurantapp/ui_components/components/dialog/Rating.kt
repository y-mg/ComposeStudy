package com.ymg.compose.restaurantapp.ui_components.components.dialog

import androidx.compose.runtime.Composable
import com.ymg.compose.restaurantapp.ui_components.models.dialog.DialogButton
import com.ymg.compose.restaurantapp.ui_components.models.dialog.DialogContent
import com.ymg.compose.restaurantapp.ui_components.models.dialog.DialogText
import com.ymg.compose.restaurantapp.ui_components.models.dialog.DialogTitle

@Composable
fun DialogPopup.Rating(
    restaurantName: String,
    rating: Float,
    buttons: List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Large("Rate your Score!"),
        dialogContent = DialogContent.Rating(
            DialogText.Rating(
                text = restaurantName,
                rating = rating
            )
        ),
        buttons = buttons
    )
}
