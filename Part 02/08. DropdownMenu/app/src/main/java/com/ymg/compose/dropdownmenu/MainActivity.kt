package com.ymg.compose.dropdownmenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ymg.compose.dropdownmenu.ui.theme.DropdownMenuTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DropdownMenuTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DropdownMenuEx()
                }
            }
        }
    }
}

@Composable
fun DropdownMenuEx() {
    var expandDropDownMenu by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { expandDropDownMenu = true }) {
            Text("드롭다운 메뉴 열기")
        }
        Text("카운터: $counter")
    }

    DropdownMenu(
        expanded = expandDropDownMenu,
        onDismissRequest = { expandDropDownMenu = false }
    ) {
        DropdownMenuItem(
            onClick = { counter++ }
        ) {
            Text("증가")
        }
        DropdownMenuItem(
            onClick = { counter-- }
        ) {
            Text("감소")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DropdownMenuTheme {
        DropdownMenuEx()
    }
}
