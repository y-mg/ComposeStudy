package com.ymg.compose.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ymg.compose.todoapp.ui.theme.ToDoAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TopLevel()
                }
            }
        }
    }
}

@Composable
fun TopLevel() {
    val (text, setText) = remember { mutableStateOf("") }
    val toDoList = remember { mutableStateListOf<ToDoData>() }
    // MutableStateList 가 추가, 삭제, 변경되었을 때만 UI 갱신
    // 항목 하나의 값을 바꾸는 것 보다는 항목 자체를 바꾸는게 더 효율적

    val onSubmit: (String) -> Unit = {
        val key = (toDoList.lastOrNull()?.key ?: 0) + 1
        toDoList.add(
            ToDoData(
                key = key,
                text = it
            )
        )
        setText("")
    }

    val onEdit: (key: Int, text: String) -> Unit = { key, text ->
        val i = toDoList.indexOfFirst { it.key == key }
        toDoList[i] = toDoList[i].copy(text = text)
    }

    val onToggle: (key: Int, checked: Boolean) -> Unit = { key, checked ->
        val i = toDoList.indexOfFirst { it.key == key }
        toDoList[i] = toDoList[i].copy(done = checked)
    }

    val onDelete: (key: Int) -> Unit = {
        toDoList.removeAt(it)
    }

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
        ) {
            ToDoInput(
                text = text,
                onTextChange = setText,
                onSubmit = onSubmit
            )
            LazyColumn {
                items(
                    items = toDoList,
                    key = { it.key }
                ) { toDoData ->
                    ToDo(
                        toDoData = toDoData,
                        onEdit = onEdit,
                        onToggle = onToggle,
                        onDelete = onDelete
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ToDoAppTheme {
        TopLevel()
    }
}

@Composable
fun ToDoInput(
    text: String,
    onTextChange: (String) -> Unit,
    onSubmit: (String) -> Unit
) {
    Row(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = {
            onSubmit(text)
        }) {
            Text("입력")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoInputPreview() {
    ToDoAppTheme {
        ToDoInput("테스트", {}, {})
    }
}

@Composable
fun ToDo(
    toDoData: ToDoData,
    onEdit: (key: Int, text: String) -> Unit = { _, _ -> },
    onToggle: (key: Int, checked: Boolean) -> Unit = { _, _ -> },
    onDelete: (key: Int) -> Unit = {}
) {
    var isEditing by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.padding(4.dp),
        elevation = 8.dp
    ) {
        Crossfade(targetState = isEditing) {
            when (it) {
                true -> {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        val (newText, setNewText) = remember { mutableStateOf(toDoData.text) }

                        OutlinedTextField(
                            value = newText,
                            onValueChange = setNewText,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(
                            modifier = Modifier.size(4.dp)
                        )
                        Button(
                            onClick = {
                                onEdit(toDoData.key, newText)
                                isEditing = false
                            }
                        ) {
                            Text(
                                text = "완료"
                            )
                        }
                    }
                }

                false -> {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(
                            text = toDoData.text,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = "완료"
                        )
                        Checkbox(
                            checked = toDoData.done,
                            onCheckedChange = { checked ->
                                onToggle(toDoData.key, checked)
                            }
                        )
                        Button(
                            onClick = {
                                isEditing = true
                            }
                        ) {
                            Text(
                                text = "수정"
                            )
                        }
                        Spacer(
                            modifier = Modifier.size(4.dp)
                        )
                        Button(
                            onClick = {
                                onDelete(toDoData.key)
                            }
                        ) {
                            Text(
                                text = "삭제"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoPreview() {
    ToDoAppTheme {
        ToDo(ToDoData(1, "nice", true))
    }
}

data class ToDoData(
    val key: Int,
    val text: String,
    val done: Boolean = false
)