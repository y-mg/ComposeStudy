package com.ymg.compose.button

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ymg.compose.button.ui.theme.ButtonTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonTheme {
                ButtonExample(onButtonClicked = {
                    Toast.makeText(this@MainActivity, "Send Click", Toast.LENGTH_LONG).show()
                })
            }
        }
    }
}

@Composable
fun ButtonExample(onButtonClicked: () -> Unit) {
    Button(
        onClick = onButtonClicked,
        enabled = true,
        border = BorderStroke(
            width = 10.dp,
            color = Color.Magenta
        ),
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(20.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(10.dp)
            // modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text(
            text = "Send",
        )
    }


    /**
     * contentPadding 은 버튼 내부의 아이콘이나 텍스트가 버튼으로부터 얼마나 떨어져 있을지 설정
     *
     * ButtonDefaults.IconSpacing 는 아이콘이 차지하는 기본 공간의 크기
     */
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ButtonTheme {
        ButtonExample(onButtonClicked = {})
    }
}