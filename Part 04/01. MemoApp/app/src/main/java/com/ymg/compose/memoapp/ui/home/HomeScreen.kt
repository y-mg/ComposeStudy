package com.ymg.compose.memoapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import com.ymg.compose.memoapp.model.Memo
import com.ymg.compose.memoapp.model.memos
import com.ymg.compose.memoapp.ui.theme.MemoAppTheme


@Composable
fun HomeScreen(homeState: HomeState) {
    MemoAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val memoList = remember { memos.sortedBy { it.id }.toMutableStateList() }
            val onClickAction: (Int) -> Unit = {
                homeState.showContent(
                    it
                )
            }

            Column {
                AddMemo(memoList)
                MemoList(onClickAction, memoList)
            }
        }
    }
}

/**
 * 역방향 쓰기 금지
 * - 역방향 쓰기는 읽힘 이후에 쓰는 것을 의미하며 무한루프를 발생시킴
 * - 컴포지션 스코프 안에서 사용하는 값을 직접 변경하는 경우 무한루프가 발생하는 문제가 생길 수 있음
 */
@Composable
fun AddMemo(memoList: SnapshotStateList<Memo>) {
    val inputValue = remember { mutableStateOf("") }
    var count by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier
            .padding(all = 16.dp)
            .height(100.dp),
        horizontalArrangement = Arrangement.End
    ) {
        TextField(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            value = inputValue.value,
            onValueChange = { textFieldValue ->
                inputValue.value = textFieldValue
            }
        )
        Button(
            onClick = {
                memoList.add(
                    index = 0,
                    Memo(memoList.size, inputValue.value)
                )
                inputValue.value = ""
                count++
            },
            modifier = Modifier
                .wrapContentWidth()
                .fillMaxHeight()
        ) {
            Text("ADD\n$count")
            //count++
        }
    }
}

/**
 * Lazy Layout 키 사용
 * - LayzyColumn 에서는 items 의 key 값을 설정하여 리컴포지션을 스킵할 수 있음
 * - Column 에서 for 문을 통해 아이템을 하니씩 가져오는 경우에는 key 를 사용해서 리컴포지션을 스킵할 수 있음
 *
 * 계산 최소화
 * - 계산하는 위치를 안쪽이 아닌 밖으로 빼서 최소화 하는 것
 * - items 안에서는 모든 시점에 변화가 있지 않아도 항상 매번 보여줄 때마다 정렬됨
 * - remember 를 사용해서 정렬된 값을 저장하고 items 에 등록하면 필요할 때만 정렬됨
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ColumnScope.MemoList(
    onClickAction: (Int) -> Unit,
    memoList: SnapshotStateList<Memo>
) {
    LazyColumn(
        modifier = Modifier
            .weight(1f)
    ) {
        items(
            items = memoList,
            key = { it.id }
        ) { memo ->
            Card(
                modifier = Modifier
                    .height(100.dp)
                    .background(Color.White)
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    )
                    .fillMaxWidth(),
                backgroundColor = Color.LightGray,
                onClick = {
                    onClickAction(memo.id)
                }
            ) {
                Text(
                    text = memo.text,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }

    /*Column(
        modifier = Modifier
            .weight(1f)
    ) {
        for (memo in memoList) {
            key(memo.id) {
                Card(
                    modifier = Modifier
                        .height(100.dp)
                        .background(Color.White)
                        .padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        )
                        .fillMaxWidth(),
                    backgroundColor = Color.LightGray,
                    onClick = {
                        onClickAction(memo.id)
                    }
                ) {
                    Text(
                        text = memo.text,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }*/
}
