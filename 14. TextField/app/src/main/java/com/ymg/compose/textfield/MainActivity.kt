package com.ymg.compose.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ymg.compose.textfield.ui.theme.TextFieldTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Hello Android")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextFieldTheme {
        Greeting()
    }
}