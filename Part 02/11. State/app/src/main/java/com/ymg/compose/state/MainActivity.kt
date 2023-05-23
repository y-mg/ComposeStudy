package com.ymg.compose.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ymg.compose.state.ui.theme.StateTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    PyeongToSquareMeter()
                }
            }
        }
    }
}

@Composable
fun PyeongToSquareMeter() {
    var pyeong by rememberSaveable {
        mutableStateOf("23")
    }
    var squaremeter by rememberSaveable {
        mutableStateOf((23 * 3.306).toString())
    }

    /*
    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = pyeong,
            onValueChange = {
                if (it.isBlank()) {
                    pyeong = ""
                    squaremeter = ""
                    return@OutlinedTextField
                }
                val numericValue = it.toFloatOrNull() ?: return@OutlinedTextField
                pyeong = it
                squaremeter = (numericValue * 3.306).toString()
            },
            label = {
                Text("평")
            }
        )
        OutlinedTextField(
            value = squaremeter,
            onValueChange = {},
            label = {
                Text("제곱미터")
            }
        )
    }
    */

    PyeongToSquareMeterStateless(
        pyeong = pyeong,
        squaremeter = squaremeter,
        onPyengChange = {
            if (it.isBlank()) {
                pyeong = ""
                squaremeter = ""
                return@PyeongToSquareMeterStateless
            }
            val numericValue = it.toFloatOrNull() ?: return@PyeongToSquareMeterStateless
            pyeong = it
            squaremeter = (numericValue * 3.306).toString()
        }
    )


    /**
     * 컴포즈는 상태가 업데이트 되지 않으면 값이 바뀌지 않음
     *
     * remember 는 캐시를 설정하게 되어 있는데 화면 회전과 같이 configuration 이 발생하는 경우에는
     * 유지되지 않아 rememberSaveable 를 사용해야 됨
     *
     * 저장 공간에 한계가 있기 때문에 모든 값에 rememberSaveable 를 적용 하는 것은 권장되지 않음
     *
     * UI 부분은 상태가 없게 만들고, 상태가 변경되는 코드를 따로 관리하는 것이 권장됨
     */
}

@Composable
fun PyeongToSquareMeterStateless(
    pyeong: String,
    squaremeter: String,
    onPyengChange: (String) -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = pyeong,
            onValueChange = onPyengChange,
            label = {
                Text("평")
            }
        )
        OutlinedTextField(
            value = squaremeter,
            onValueChange = {},
            label = {
                Text("제곱미터")
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StateTheme {
        PyeongToSquareMeter()
    }
}