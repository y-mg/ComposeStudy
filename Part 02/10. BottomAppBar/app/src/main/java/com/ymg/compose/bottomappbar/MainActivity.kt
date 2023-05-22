package com.ymg.compose.bottomappbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ymg.compose.bottomappbar.ui.theme.BottomAppBarTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomAppBarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BottomAppBarEx()
                }
            }
        }
    }
}

@Composable
fun BottomAppBarEx() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    var counter by remember { mutableStateOf(0) }

    Scaffold(
        scaffoldState = scaffoldState,
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = it)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "카운터는 ${counter}회 입니다.",
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        },
        bottomBar = {
            BottomAppBar {
                Text("Hello")
                Button(
                    onClick = {
                        coroutineScope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("안녕하세요")
                        }
                    }
                ) {
                    Text("인사")
                }
                Button(
                    onClick = {
                        counter++
                        coroutineScope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("${counter} 입니다.")
                        }
                    }
                ) {
                    Text("증가")
                }
                Button(
                    onClick = {
                        counter--
                        coroutineScope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("${counter} 입니다.")
                        }
                    }
                ) {
                    Text("감소")
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BottomAppBarTheme {
        BottomAppBarEx()
    }
}