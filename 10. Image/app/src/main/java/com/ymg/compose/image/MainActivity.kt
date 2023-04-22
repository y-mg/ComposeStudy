package com.ymg.compose.image

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ymg.compose.image.ui.theme.ImageTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    Column {
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ImageTheme {
        Greeting()
    }
}