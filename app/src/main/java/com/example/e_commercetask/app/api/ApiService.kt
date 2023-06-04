package com.example.e_commercetask.app.api

import com.example.e_commercetask.loginScreen.data.models.LoginUserRequest
import com.example.e_commercetask.loginScreen.data.models.LoginUserResponse
import com.example.e_commercetask.productsList.data.models.ProductItemModel
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @POST("auth/login")
    suspend fun loginUser(
        @Body
        loginUserRequest: LoginUserRequest
    ): Response<LoginUserResponse>

    @Headers("Accept: application/json")
    @GET("products")
    suspend fun getAllProducts(): Response<ArrayList<ProductItemModel>>
}