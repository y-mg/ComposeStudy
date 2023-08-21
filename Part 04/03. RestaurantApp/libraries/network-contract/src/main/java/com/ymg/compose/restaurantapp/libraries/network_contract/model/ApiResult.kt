package com.ymg.compose.restaurantapp.libraries.network_contract.model

import com.google.gson.annotations.SerializedName

class ApiResult<T>(
    @SerializedName("response")
    val response: ApiResponse<T>,
    @SerializedName("headers")
    val headers: Map<String, String> = emptyMap(),
    @SerializedName("code")
    val code: Int = -1,
)
