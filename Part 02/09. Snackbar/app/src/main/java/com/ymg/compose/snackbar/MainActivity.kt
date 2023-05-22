package com.ymg.compose.snackbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ymg.compose.snackbar.ui.theme.SnackbarTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnackbarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SnackbarEx()
                }
            }
        }
    }
}

@Composable
fun SnackbarEx() {
    var counter by remember { mutableStateOf(0) }
    val scaffoldState = rememberScaffoldState()

    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = it)
            ) {
                Button(
                    onClick = {
                        counter++
                        coroutineScope.launch {
                            val result = scaffoldState.snackbarHostState.showSnackbar(
                                message = "카운터는 $counter 입니다.",
                                actionLabel = "닫기",
                                duration = SnackbarDuration.Short
                            )

                            when (result) {
                                SnackbarResult.Dismissed -> {}
                                SnackbarResult.ActionPerformed -> {}
                            }
                        }
                    }
                ) {
                    Text("더하기")
                }
            }
        }
    )


    /**
     * rememberScaffoldState 는 scaffoldState 를 만들고 기억하는 함수
     *
     * 코루틴 스코프를 만드는 이유는 스낵바가 suspend 함수이기 때문임
     *
     * 컴포저블 함수로 Snackbar 가 있지만 스낵바가 사라지는 행동, 애니메이션 등 모든 것을 정의해야해서 사용하기 까다롭기 때문에
     * 간단한 것은 scaffoldState 의 snackbarHostState 를 통해 스낵바를 사용하는 것이 권장됨
     */
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SnackbarTheme {
        SnackbarEx()
    }
}