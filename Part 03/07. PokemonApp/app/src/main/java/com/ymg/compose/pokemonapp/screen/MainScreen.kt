package com.ymg.compose.pokemonapp.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.ymg.compose.pokemonapp.viewmodel.PokemonViewModel


@Composable
fun MainScreen(
    onPokemonClick: (String) -> Unit,
    viewModel: PokemonViewModel = hiltViewModel()
) {
    val items = viewModel.pokemonList.collectAsLazyPagingItems()
    LazyColumn {
        items(
            items = items,
            key = { it.url }
        ) {
            it?.let {
                Card(
                    elevation = 8.dp,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Column {
                            Text("포케몬: ${it.name}")
                            Text(
                                text = it.url,
                                Modifier.alpha(0.4f)
                            )
                        }
                        Spacer(modifier = Modifier.size(16.dp))
                        Button(onClick = {
                            onPokemonClick(it.url)
                        }) {
                            Text("보기")
                        }
                    }
                }
            }
        }
    }
}