package com.ymg.compose.checkbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ymg.compose.checkbox.ui.theme.CheckBoxTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckBoxTheme {
                CheckBoxEx()
            }
        }
    }
}

@Composable
fun CheckBoxEx() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        // val checked = remember { mutableStateOf(false) }
        // var checked by remember { mutableStateOf(false) }
        val (checked, setChecked) = remember { mutableStateOf(false) }

        Checkbox(
            /*
            checked = checked.value,
            onCheckedChange = {
                checked.value = it
            }
            */
            /*
            checked = checked,
            onCheckedChange = {
                checked = it
            }
            */
            checked = checked,
            onCheckedChange = {
                setChecked(it)
            }
        )
        Text(
            text = "프로그래머입니까?",
            modifier = Modifier.clickable {
                // checked.value = !checked.value
                // checked = !checked
                setChecked(!checked)
            }
        )
    }


    /**
     * 안드로이드의 기존 레거시(XML)로 만든 Checkbox 에서는 별도의 코드 없이도 클릭하면 체크가 됨
     *
     * Compose 에서는 checked 의 값이 바뀌지 않으면 클릭해도 동작하지 않음
     *
     * Compose 에서는 다시 그려지는 과정이 반복되는데 이것을 Recomposition 이라 하며, 상태가 바뀌어야 Recomposition 일어나고
     * UI 가 갱신되며, 여기서 상태는 코드로는 mutableStateOf() 를 말함
     *
     * 컴포저블은 중단되거나, 새로 그려지거나, 여러 스레드에서 여러 컴포저블을 계산하고 합쳐서 하나의 UI 를 만든다던지 등
     * 언제든지 상태가 저장되지 않고 지워질 수 있음
     *
     * remember 를 사용하면 상태를 기억했다가 나중에 다시 사용할 수 있게 함
     *
     * by 키워드를 통해 위임된 속성(delegated properties)을 사용하면 value 프로퍼티 자체인 것처럼 사용할 수 있는데
     * 예를 들면, checked 가 checked.value 프로퍼티인 것처럼 사용이 가능
     *
     * 비구조화(destruction)를 통해 상태를 받아와 처리하는 것도 가능한데, mutableStateOf() 의 반환형인 MutableState 의
     * getter 인 component1() 과 setter 인 component2() 를 받아오는 것을 의미함
     */
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CheckBoxTheme {
        CheckBoxEx()
    }
}