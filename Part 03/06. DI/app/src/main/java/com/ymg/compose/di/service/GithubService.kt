package com.ymg.compose.di.service

import com.ymg.compose.di.model.Repo
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubService {
    @GET("users/{user}/repos")
    suspend fun listRepos(@Path("user") user: String): List<Repo>
}