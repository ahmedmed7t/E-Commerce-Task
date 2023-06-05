package com.example.e_commercetask.loginScreen.data.data_source

import com.example.e_commercetask.loginScreen.data.models.LoginUserRequest
import com.example.e_commercetask.loginScreen.data.models.LoginUserResponse
import retrofit2.Response

interface LoginDataSource {
    suspend fun loginUser(
        loginUserRequest: LoginUserRequest
    ): Response<LoginUserResponse>
}