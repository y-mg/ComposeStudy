package com.ymg.compose.movieapp.ui.components.dialog

import androidx.compose.runtime.Composable
import com.ymg.compose.movieapp.ui.models.dialog.DialogButton
import com.ymg.compose.movieapp.ui.models.dialog.DialogContent
import com.ymg.compose.movieapp.ui.models.dialog.DialogText
import com.ymg.compose.movieapp.ui.models.dialog.DialogTitle


@Composable
fun DialogPopup.Alert(
    title: String,
    bodyText: String,
    buttons: List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Header(
            title
        ),
        dialogContent = DialogContent.Large(
            DialogText.Default(
                bodyText
            )
        ),
        buttons = buttons
    )
}
