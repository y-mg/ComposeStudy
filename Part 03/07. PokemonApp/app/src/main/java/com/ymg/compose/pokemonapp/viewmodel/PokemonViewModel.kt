package com.ymg.compose.pokemonapp.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.ymg.compose.pokemonapp.PokeAPI
import com.ymg.compose.pokemonapp.PokemonResponse
import com.ymg.compose.pokemonapp.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val pokeAPI: PokeAPI
) : ViewModel() {

    val pokemonList: Flow<PagingData<Response.Result>> = getPokemons().cachedIn(viewModelScope)
    var pokemonResult by mutableStateOf(
        PokemonResponse(
            PokemonResponse.Species(""),
            PokemonResponse.Sprites("")
        )
    )

    private fun getPokemons(): Flow<PagingData<Response.Result>> = Pager(
        config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = true,
            prefetchDistance = 5
        ),
        pagingSourceFactory = {
            object : PagingSource<Int, Response.Result>() {
                override fun getRefreshKey(state: PagingState<Int, Response.Result>): Int? {
                    return state.anchorPosition
                }

                override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Response.Result> {
                    try {
                        val pokemons = if (params.key != null) {
                            pokeAPI.getPokemons(params.key as Int, params.loadSize)
                        } else {
                            pokeAPI.getPokemons()
                        }

                        // offset=20&limit=20
                        return LoadResult.Page(
                            data = pokemons.results,
                            prevKey = pokemons.previous?.substringAfter("offset=")
                                ?.substringBefore("&")
                                ?.toInt(),
                            nextKey = pokemons.next?.substringAfter("offset=")
                                ?.substringBefore("&")
                                ?.toInt()
                        )
                    } catch (e: Exception) {
                        Log.e("EEE", "error: $e")
                        e.printStackTrace()
                        return LoadResult.Error(e)
                    }
                }
            }
        }
    ).flow

    fun getPokemon(pokemonId: Int) {
        viewModelScope.launch {
            pokemonResult = pokeAPI.getPokemon(pokemonId)
        }
    }
}