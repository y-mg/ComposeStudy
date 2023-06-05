package com.ymg.compose.compositionlocal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ymg.compose.compositionlocal.ui.theme.CompositionLocalTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

val LocalElevation = compositionLocalOf { 8.dp }

@Composable
fun Greeting() {
    CompositionLocalProvider(LocalElevation provides 12.dp) {
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = LocalElevation.current
        ) {
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
                Column(
                    modifier = Modifier.padding(16.dp),
                ) {
                    Text("안녕하세요. 저는누구에요")
                    Text("${LocalContentColor.current}")
                    Text("${LocalContentAlpha.current}")

                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                        Text("요안녕하세요. 저는누구에")
                        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                            Text("에요안녕하세요. 저는누구")
                        }

                        CompositionLocalProvider(LocalContentColor provides  Color.Magenta) {
                            Text("구에요안녕하세요. 저는누")
                            Text("누구에요안녕하세요. 저는")
                            Text("${LocalContentColor.current}")
                            Text("${LocalContentAlpha.current}")
                        }
                    }
                    Text("는누구에요안녕하세요. 저")
                    Text("저는누구에요안녕하세요.")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CompositionLocalTheme {
        Greeting()
    }
}