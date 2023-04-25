package com.ymg.compose.slot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ymg.compose.slot.ui.theme.SlotTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SlotTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SlotEx()
                }
            }
        }
    }
}

@Composable
fun SlotEx() {
    val checked1 = remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(false) }

    Column {
        /*
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checked1.value,
                onCheckedChange = { checked1.value = it }
            )
            Text(
                text = "텍스트 1",
                modifier = Modifier.clickable { checked1.value = !checked1.value }
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checked2.value,
                onCheckedChange = { checked2.value = it }
            )
            Text(
                text = "텍스트 2",
                modifier = Modifier.clickable { checked2.value = !checked2.value }
            )
        }
        */
        CheckboxWithSlotApi(
            checked = checked1
        ) {
            Text(text = "텍스트 1")
        }
        CheckboxWithSlotApi(
            checked = checked2,
            onCheckedChanged = {
                checked2 = !checked2
            }
        ) {
            Text(text = "텍스트 2")
        }
    }
}

@Composable
fun CheckboxWithSlotApi(
    checked: MutableState<Boolean>,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            checked.value = !checked.value
        }
    ) {
        Checkbox(
            checked = checked.value,
            onCheckedChange = { checked.value = it }
        )
        content()
    }


    /**
     * 컴포저블 함수가 다른 컴포저블 함수나 컴포넌트를 포함할 수 있게 하는 것을 Slot API 라고 하며,
     * 코드로는 앞에 @Composable 를 붙여주는 것을 말함 (여기서는 content 에 해당)
     */
}

@Composable
fun CheckboxWithSlotApi(
    checked: Boolean,
    onCheckedChanged: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            onCheckedChanged()
        }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChanged() }
        )
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SlotTheme {
        SlotEx()
    }
}
