package com.ymg.compose.canvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ymg.compose.canvas.ui.theme.CanvasTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanvasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CanvasEx()
                }
            }
        }
    }
}

@Composable
fun CanvasEx() {
    Canvas(modifier = Modifier.size(20.dp)) {
        drawLine(
            color = Color.Red,
            start = Offset(30f, 10f),
            end = Offset(50f, 40f)
        )

        drawCircle(
            color = Color.Yellow,
            radius = 10f,
            center = Offset(15f, 40f)
        )

        drawRect(
            color = Color.Magenta,
            topLeft = Offset(30f, 30f),
            size = Size(10f, 10f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CanvasTheme {
        CanvasEx()
    }
}