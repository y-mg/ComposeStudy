package com.ymg.compose.box

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ymg.compose.box.ui.theme.BoxTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxTheme {
                BoxEx()
            }
        }
    }
}

@Composable
fun BoxEx() {
    Box {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(Color.Cyan)
                .align(Alignment.TopCenter)
            // modifier = Modifier.matchParentSize()
            // modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier.size(80.dp)
                .background(Color.Yellow)
                .align(Alignment.Center)
        )
        Box(
            modifier = Modifier.size(90.dp)
                .background(Color.Green)
                .align(Alignment.BottomCenter)
        )
        Text(
            text = "Hello World",
            modifier = Modifier.align(Alignment.TopCenter)
        )
        Text(
            text = "Jetpack",
            modifier = Modifier.align(Alignment.Center)
        )
        Text(
            text = "Compose",
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }


    /**
     * Box 내부에서 View 가 겹치면 먼저 배치된 View 가 아래에 깔림
     *
     * Modifier.matchParentSize() 는 부모 Box 의 크기를 따라감
     *
     * Modifier.fillMaxSize() 는 크기를 최대한으로 늘림
     */
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BoxTheme {
        BoxEx()
    }
}