package com.ymg.compose.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ToDoViewModel : ViewModel() {

    private val _text = MutableLiveData("")
    val text: LiveData<String> = _text
    val setText: (String) -> Unit = {
        _text.value = it
    }

    private val _rawToDoList = mutableListOf<ToDoData>()
    private val _toDoList = MutableLiveData<List<ToDoData>>(_rawToDoList)
    val toDoList: LiveData<List<ToDoData>> = _toDoList

    val onSubmit: (String) -> Unit = {
        val key = (_rawToDoList.lastOrNull()?.key ?: 0) + 1
        _rawToDoList.add(ToDoData(key, it))
        // _toDoList.value = ArrayList(_rawToDoList)
        // _toDoList.value = _rawToDoList.toMutableList()
        _toDoList.value = mutableListOf<ToDoData>().also { list ->
            list.addAll(_rawToDoList) // shallow copy
        }
        _text.value = ""
    }

    val onEdit: (Int, String) -> Unit = { key, newText ->
        val i = _rawToDoList.indexOfFirst { it.key == key }
        _rawToDoList[i] = _rawToDoList[i].copy(text = newText)
        _toDoList.value = mutableListOf<ToDoData>().also { list ->
            list.addAll(_rawToDoList)
        }
    }

    val onToggle: (Int, Boolean) -> Unit = { key, checked ->
        val i = _rawToDoList.indexOfFirst { it.key == key }
        _rawToDoList[i] = _rawToDoList[i].copy(done = checked)
        _toDoList.value = mutableListOf<ToDoData>().also { list ->
            list.addAll(_rawToDoList)
        }
    }

    val onDelete: (Int) -> Unit = { key ->
        val i = _rawToDoList.indexOfFirst { it.key == key }
        _rawToDoList.removeAt(i)
        _toDoList.value = mutableListOf<ToDoData>().also { list ->
            list.addAll(_rawToDoList)
        }
    }


    /**
     * mutableStateListOf 같은 경우는 추가, 삭제, 업데이트가 발생하여야 UI 가 갱신되는데,
     * 다만 각 항목의 필드가 바뀌었을 때는 갱신이 되지 않음
     *
     * LiveData<List<T>>.observeAsState() 같은 경우는 List 가 전부 다른
     * List 로 바뀌었을 때만 State 가 갱신됨 (권장 X)
     */
}