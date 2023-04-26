package com.ymg.compose.column

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    Column(
        modifier = Modifier.size(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "첫 번째",
            modifier = Modifier.weight(3f).background(Color.Magenta)
            // modifier = Modifier.align(Alignment.Start)
        )
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "추가",
            modifier = Modifier.weight(3f)
        )
        Text(
            text = "세 번째",
            modifier = Modifier.weight(3f).background(Color.Cyan)
        )
    }


    /**
     * Column 은 수직으로 배치하는 것이기 때문에 정렬은 항상 수평으로 됨
     *
     * Column 내부의 항목에 정렬을 모두 동일하게 적용을 하고 싶다면 Column 에 horizontalAlignment 을 설정하면 됨
     *
     * horizontalAlignment 을 적용한 상태에서 Column 내부의 항목에 Modifier.align() 을 적용하면 개별 적용이 됨
     *
     * Arrangement 는 내부의 항목들에 대한 배치를 설정함
     */
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ColumnTheme {
        ColumnEx()
    }
}
