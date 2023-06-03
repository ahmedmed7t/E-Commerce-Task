package com.example.e_commercetask.loginScreen.data.data_source

import com.example.e_commercetask.app.api.ApiService
import com.example.e_commercetask.loginScreen.data.models.LoginUserRequest
import javax.inject.Inject

class LoginDataSourceImp @Inject constructor(private val apiService: ApiService): LoginDataSource {
    override suspend fun loginUser(loginUserRequest: LoginUserRequest) =
        apiService.loginUser(loginUserRequest)
}