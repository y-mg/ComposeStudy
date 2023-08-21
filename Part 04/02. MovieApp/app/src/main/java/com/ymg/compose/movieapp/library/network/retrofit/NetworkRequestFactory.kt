package com.ymg.compose.movieapp.library.network.retrofit

import com.ymg.compose.movieapp.library.network.model.ApiResult
import com.ymg.compose.movieapp.library.network.model.NetworkRequestInfo
import java.lang.reflect.Type


interface NetworkRequestFactory {

    suspend fun <T> create(
        url: String,
        requestInfo: NetworkRequestInfo = NetworkRequestInfo.Builder().build(),
        type: Type
    ): ApiResult<T>
}
