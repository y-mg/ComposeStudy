package com.ymg.compose.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ymg.compose.navigation.ui.theme.NavigationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyNav()
                }
            }
        }
    }
}

@Composable
fun MyNav(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "Home",
        modifier = modifier
    ) {
        composable("Home") {
            Column {
                Text("Home")
                Button(onClick = {
                    navController.navigate("Office") {
                        popUpTo("Home") {
                            inclusive = true
                        }
                    }
                }) {
                    Text("Office 이동")
                }
                Button(onClick = {
                    navController.navigate("Playground") {
                        popUpTo("Home") {
                            inclusive = true
                        }
                    }
                }) {
                    Text("Playground 이동")
                }
                Button(onClick = {
                    navController.navigate("Home") {
                        launchSingleTop = true
                    }
                }) {
                    Text("Home 이동")
                }
                Button(onClick = {
                    navController.navigate("Argument/y-mg") {
                        launchSingleTop = true
                    }
                }) {
                    Text("User ID 로 연결")
                }
            }
        }
        composable("Office") {
            Column {
                Text("Office")
                Button(onClick = {
                    navController.navigate("Playground") {
                        popUpTo("Home") {
                            inclusive = true
                        }
                    }
                }) {
                    Text("Playground 이동")
                }
                Button(onClick = {
                    navController.navigate("Home") {
                        popUpTo("Home") {
                            inclusive = true
                        }
                    }
                }) {
                    Text("Home 이동")
                }
            }
        }
        composable("Playground") {
            Column {
                Text("Playground")
                Button(onClick = {
                    navController.navigate("Home") {
                        popUpTo("Home") {
                            inclusive = true
                        }
                    }
                }) {
                    Text("Home 이동")
                }
                Button(onClick = {
                    navController.navigate("Office") {
                        popUpTo("Home") {
                            inclusive = true
                        }
                    }
                }) {
                    Text("Office 이동")
                }
            }
        }

        composable("Argument/{userId}") {
            val userId = it.arguments?.getString("userId")
            Text("User ID: $userId")
        }
    }


    /**
     * popUpTo() 는 설정한 route 이후에 생성되는 스택을 제거한다.
     *
     * inclusive = true 를 설정하면 설정한 route 조차 제거한다.
     *
     * launchSingleTop = true 를 설정하면 이미 생성되어 있는 스택은 다시 생성하지 않는다.
     */
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavigationTheme {
        MyNav()
    }
}