package com.ymg.compose.surface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ymg.compose.surface.ui.theme.SurfaceTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SurfaceTheme {
                Greeting("Android")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Surface(
        modifier = Modifier.padding(5.dp),
        elevation = 10.dp,
        border = BorderStroke(
            width = 2.dp,
            color = Color.Magenta
        ),
        shape = CircleShape,
        color = MaterialTheme.colors.primary
    ) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(8.dp)
        )
    }


    /**
     * Surface 는 padding 만 적용 가능하며 내부에 터치를 전달하지 않음
     *
     * Surface 에 color 를 설정하면 contentColor 가 자동으로 선택되어 색상이 적용됨
     */
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SurfaceTheme {
        Greeting("Android")
    }
}