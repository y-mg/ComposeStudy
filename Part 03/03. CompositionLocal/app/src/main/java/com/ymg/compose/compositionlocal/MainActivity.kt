package com.ymg.compose.compositionlocal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

@Composable
fun Greeting() {
    Card(
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            Text("안녕하세요. 저는누구에요")
            Text("요안녕하세요. 저는누구에")
            Text("에요안녕하세요. 저는누구")
            Text("구에요안녕하세요. 저는누")
            Text("누구에요안녕하세요. 저는")
            Text("는누구에요안녕하세요. 저")
            Text("저는누구에요안녕하세요.")
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