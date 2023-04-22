package com.ymg.compose.column

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ymg.compose.column.ui.theme.ColumnTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColumnTheme {
                ColumnEx()
            }
        }
    }
}

@Composable
fun ColumnEx() {
    Column(modifier = Modifier.size(100.dp)) {
        Text(text = "첫 번째")
        Text(text = "두 번째")
        Text(text = "세 번째")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ColumnTheme {
        ColumnEx()
    }
}
