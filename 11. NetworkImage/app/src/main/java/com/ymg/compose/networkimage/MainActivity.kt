package com.ymg.compose.networkimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.ymg.compose.networkimage.ui.theme.NetworkImageTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetworkImageTheme {
                NetworkImageEx()
            }
        }
    }
}

@Composable
fun NetworkImageEx() {
    /*
    val painter = rememberImagePainter(
        data = "https://youimg1.tripcdn.com/target/10081f000001gqgcb2CEB.jpg?proc=source%2Ftrip"
    )
    Image(
        painter = painter,
        contentDescription = "엔텔로프 캐넌"
    )
    */

    Column {
        AsyncImage(
            model = "https://youimg1.tripcdn.com/target/10081f000001gqgcb2CEB.jpg?proc=source%2Ftrip",
            contentDescription = "엔텔로프 캐넌"
        )
        AsyncImage(
            model = "https://youimg1.tripcdn.com/target/10081f000001gqgcb2CEB.jpg?proc=source%2Ftrip",
            contentDescription = "엔텔로프 캐넌"
        )
    }


    /**
     * Coil 은 이미지 라이브러리로 Kotlin 및 Compose 친화적
     *
     * 2023-04-19 기준 공식 문서에는 rememberImagePainter 로 가이드하지만 deprecated 됨
     *
     * 앞에 remember 키워드는 내용을 저장했다가 다시 컴포저블이 재호출될 때 기억했다가 알려준다는 의미
     *
     * Coil 의 문서에서는 AsyncImage 를 사용할 것을 권장
     */
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NetworkImageTheme {
        NetworkImageEx()
    }
}