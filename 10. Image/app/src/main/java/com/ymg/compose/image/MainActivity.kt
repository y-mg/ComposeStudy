package com.ymg.compose.image

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
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
        Image(
            painter = painterResource(id = R.drawable.wall),
            contentDescription = "엔텔로프 캐니언"
        )
        Image(
            imageVector = Icons.Filled.Settings,
            contentDescription = "Setting"
        )
    }


    /**
     * Compose 에서 Image 를 그리는 방식은 painter, vector, bitmap 3가지
     */
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ImageTheme {
        Greeting()
    }
}