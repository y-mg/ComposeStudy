package com.ymg.compose.modifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ymg.compose.modifier.ui.theme.ModifierTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModifierTheme {
                ModifierEx()
            }
        }
    }
}

@Composable
fun ModifierEx() {
    Button(
        onClick = {},
        // enabled = false,
        modifier = Modifier
            .size(200.dp, 100.dp)
            .padding(10.dp),
        // modifier = Modifier.fillMaxSize()
        // modifier = Modifier.width(100.dp).height(100.dp)
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Magenta,
            contentColor = Color.Cyan
        )
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null,
            modifier = Modifier.background(Color.Blue)
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing).background(Color.Blue)
        )
        Text(
            text = "Search",
            modifier = Modifier.offset(x = 10.dp).background(Color.Blue),
            // modifier = Modifier.clickable {}
        )
    }


    /**
     * Modifier.fillMax···() 은 크기를 가능한 최대한으로 늘림
     *
     * 가로, 세로 모두의 크기를 조정할 때는 Modifier.width().height() 보다 size 를 사용을 권장
     *
     * Button 에서는 Modifier.background(Color.Red) 와 같이 Modifier 로 버튼의 색상을 바꿀 수 없음
     *
     * Button 을 enabled = false 하고 Text 에 Modifier.clickable {} 옵션을 주면 Button 내부의 Text 는 클릭 가능
     */
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ModifierTheme {
        ModifierEx()
    }
}