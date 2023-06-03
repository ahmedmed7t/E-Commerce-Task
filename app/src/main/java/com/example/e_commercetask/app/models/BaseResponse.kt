package com.example.e_commercetask.app.models

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("total_pages")
    val totalPages: Long?,
    @SerializedName("total_results")
    val totalResults: Long?,
    @SerializedName("results")
    val results: T?,
    @SerializedName("status_code")
    val status_code: Int?,
    @SerializedName("status_message")
    val statusMessage: String,
    @SerializedName("success")
    val success: Boolean?
)
