package com.ymg.compose.restaurantapp.ui_components.components.dialog

import androidx.compose.runtime.Composable
import com.ymg.compose.restaurantapp.ui_components.models.dialog.DialogButton
import com.ymg.compose.restaurantapp.ui_components.models.dialog.DialogContent
import com.ymg.compose.restaurantapp.ui_components.models.dialog.DialogText
import com.ymg.compose.restaurantapp.ui_components.models.dialog.DialogTitle

object DialogPopup

@Composable
fun DialogPopup.Default(
    title: String,
    bodyText: String,
    buttons: List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Default(title),
        dialogContent = DialogContent.Default(
            DialogText.Default(bodyText)
        ),
        buttons = buttons
    )
}
