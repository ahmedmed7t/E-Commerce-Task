package com.example.e_commercetask.loginScreen.domain.repository

import com.example.e_commercetask.loginScreen.data.models.LoginUserResponse
import retrofit2.Response

interface LoginRepository {

    suspend fun loginUser(
        userName: String, password: String
    ): Response<LoginUserResponse>

    fun saveUserToken(
        userToken: String
    )
}