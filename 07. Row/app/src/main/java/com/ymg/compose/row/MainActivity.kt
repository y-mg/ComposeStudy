package com.ymg.compose.row

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ymg.compose.row.ui.theme.RowTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RowTheme {
                RowEx()
            }
        }
    }
}

@Composable
fun RowEx() {
    Row(modifier = Modifier.height(40.dp)) {
        Text(text = "첫 번째!")
        Text(text = "두 번째!")
        Text(text = "세 번째!")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RowTheme {
        RowEx()
    }
}