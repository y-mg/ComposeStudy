package com.ymg.compose.animation02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ymg.compose.animation02.ui.theme.Animation02Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Animation02Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    Animation2Ex()
                }
            }
        }
    }
}

@Composable
fun Animation2Ex() {
    var isDarkMode by remember { mutableStateOf(false) }

    val transition = updateTransition(
        targetState = isDarkMode,
        label = "다크 모드 트랜지션"
    )

    val backgroundColor by transition.animateColor(label = "다크 모드 배경색상 애니메이션") { state ->
        when (state) {
            true -> {
                Color.Black
            }

            false -> {
                Color.White
            }
        }
    }

    val color by transition.animateColor(label = "다크 모드 글자 색상 애니메이션") { state ->
        when (state) {
            true -> {
                Color.White
            }

            false -> {
                Color.Black
            }
        }
    }

    val alpha by transition.animateFloat(label = "다크 모드 알파 애니메이션") { state ->
        when (state) {
            true -> {
                1f
            }

            false -> {
                0.7f
            }
        }
    }

    Column(
        modifier = Modifier
            .background(backgroundColor)
            .alpha(alpha)
    ) {
        RadioButtonWithText(text = "일반 모드", selected = !isDarkMode, color = color) {
            isDarkMode = false
        }
        RadioButtonWithText(text = "다크 모드", selected = isDarkMode, color = color) {
            isDarkMode = true
        }

        Crossfade(targetState = isDarkMode) {state ->
            when (state) {
                true -> {
                    Row {
                        Box(modifier = Modifier
                            .background(Color.Red)
                            .size(20.dp)) {
                            Text("1")
                        }
                        Box(modifier = Modifier
                            .background(Color.Magenta)
                            .size(20.dp)) {
                            Text("2")
                        }
                        Box(modifier = Modifier
                            .background(Color.Blue)
                            .size(20.dp)) {
                            Text("3")
                        }
                    }
                }

                false -> {
                    Column {
                        Box(modifier = Modifier
                            .background(Color.Red)
                            .size(20.dp)) {
                            Text("A")
                        }
                        Box(modifier = Modifier
                            .background(Color.Magenta)
                            .size(20.dp)) {
                            Text("B")
                        }
                        Box(modifier = Modifier
                            .background(Color.Blue)
                            .size(20.dp)) {
                            Text("C")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Animation02Theme {
        Animation2Ex()
    }
}

@Preview(showBackground = true)
@Composable
fun RadioButtonWithTextPreview() {
    Animation02Theme {
        RadioButtonWithText(
            text = "라디오 버튼",
            color = Color.Red,
            selected = true,
            onClick = {}
        )
    }
}

@Composable
fun RadioButtonWithText(
    text: String,
    color: Color = Color.Black,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.selectable(
            selected = selected,
            onClick = onClick
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = selected, onClick = onClick)
        Text(text = text, color = color)
    }
}