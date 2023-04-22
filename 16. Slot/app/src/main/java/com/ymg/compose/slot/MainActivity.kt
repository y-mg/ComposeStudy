package com.ymg.compose.slot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
    val checked2 = remember { mutableStateOf(false) }

    Column {
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
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SlotTheme {
        SlotEx()
    }
}
