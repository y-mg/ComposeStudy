package com.ymg.compose.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ymg.compose.textfield.ui.theme.TextFieldTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    var name by remember {
        mutableStateOf("Tom")
    }

    Column(
        modifier = Modifier.padding(16.dp))
    {
        /*
        TextField(
            label = {
                Text("이름")
            },
            value = name,
            onValueChange = {
                name = it
            }
        )
        */
        OutlinedTextField(
            label = {
                Text("이름")
            },
            value = name,
            onValueChange = {
                name = it
            }
        )
        Spacer(
            modifier = Modifier.size(8.dp)
        )
        Text(text = "Hello $name")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextFieldTheme {
        Greeting()
    }
}