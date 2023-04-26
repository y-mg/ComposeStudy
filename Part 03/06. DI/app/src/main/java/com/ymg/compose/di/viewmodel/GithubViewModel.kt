package com.ymg.compose.di.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ymg.compose.di.model.Repo
import com.ymg.compose.di.service.GithubService
import kotlinx.coroutines.launch


class GithubViewModel(
    private val githubService: GithubService
) : ViewModel() {
    val repos = mutableStateListOf<Repo>()

    fun getRepos() {
        repos.clear()
        viewModelScope.launch {
            val result = githubService.listRepos("y-mg")
            repos.addAll(result)
        }
    }
}