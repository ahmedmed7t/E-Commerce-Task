package com.example.e_commercetask.app.api

import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @Headers("Accept: application/json")
    @GET("products")
    suspend fun getAllProducts(
    ): Response<ArrayList<Unit>>
}