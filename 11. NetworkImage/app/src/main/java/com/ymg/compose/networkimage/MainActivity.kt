package com.ymg.compose.networkimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NetworkImageTheme {
        NetworkImageEx()
    }
}