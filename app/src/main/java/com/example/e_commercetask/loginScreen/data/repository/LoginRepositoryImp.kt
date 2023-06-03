package com.example.e_commercetask.loginScreen.data.repository

import com.example.e_commercetask.loginScreen.data.data_source.LoginDataSource
import com.example.e_commercetask.loginScreen.data.local_data_sorce.LocalLoginDS
import com.example.e_commercetask.loginScreen.data.models.LoginUserRequest
import com.example.e_commercetask.loginScreen.data.models.LoginUserResponse
import com.example.e_commercetask.loginScreen.domain.repository.LoginRepository
import com.example.e_commercetask.productsList.data.data_source.ProductsListDataSource
import com.example.e_commercetask.productsList.domain.repository.ProductsListRepository
import retrofit2.Response
import javax.inject.Inject

class LoginRepositoryImp @Inject constructor(
    private val dataSource: LoginDataSource,
    private val localLoginDS: LocalLoginDS
) :
    LoginRepository {
    override suspend fun loginUser(
        userName: String,
        password: String
    ) = dataSource.loginUser(LoginUserRequest(userName, password))

    override fun saveUserToken(userToken: String) =
        localLoginDS.saveUserToken(userToken)
}