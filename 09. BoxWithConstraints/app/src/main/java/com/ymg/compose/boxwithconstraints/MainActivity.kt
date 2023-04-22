package com.ymg.compose.boxwithconstraints

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ymg.compose.boxwithconstraints.ui.theme.BoxWithConstraintsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxWithConstraintsTheme {
                Outer()
            }
        }
    }
}

@Composable
fun Outer() {
    Column {
        Inner()
    }
}

@Composable
private fun Inner() {
    BoxWithConstraints {
        Text("maxW:$maxWidth maxH:$maxHeight minW: $minWidth minH:$minHeight")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BoxWithConstraintsTheme {
        Outer()
    }
}