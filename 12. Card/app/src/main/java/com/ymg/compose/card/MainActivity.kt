package com.ymg.compose.card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ymg.compose.card.ui.theme.CardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        CardEx(cardData)
                        CardEx(cardData)
                    }
                }
            }
        }
    }

    companion object {
        val cardData = CardData(
            imageUri = "https://www.gousa.or.kr/sites/default/files/styles/16_9_1280x720/public/images/hero_media_image/2016-12/lower-antelope-canyon-and-sky.jpg?h=c65aac25&itok=le2Fr6e2",
            imageDescription = "엔텔로프 캐년",
            author = "Dalinaum",
            description = "엔텔로프 캐년은 죽기 전에 꼭 봐야할 절경으로 소개되었습니다."
        )
    }
}

@Composable
fun CardEx(cardData: CardData) {
    val placeHolderColor = Color(0x33000000)

    Card(
        elevation = 8.dp,
        modifier = Modifier.padding(4.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CardTheme {
        Row {
            CardEx(MainActivity.cardData)
        }
    }
}

data class CardData(
    val imageUri: String,
    val imageDescription: String,
    val author: String,
    val description: String
)