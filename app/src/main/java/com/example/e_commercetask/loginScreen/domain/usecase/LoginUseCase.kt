package com.example.e_commercetask.loginScreen.domain.usecase

import com.example.e_commercetask.loginScreen.domain.models.LoginNetworkState
import com.example.e_commercetask.loginScreen.domain.repository.LoginRepository
import com.example.e_commercetask.productsList.domain.repository.ProductsListRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    suspend operator fun invoke(userName: String, password: String): LoginNetworkState{
        loginRepository.loginUser(userName, password).let { response ->
            return if(response.isSuccessful){
                LoginNetworkState.LoginSuccess(response.body()?.token ?: "")
            }else{
                LoginNetworkState.LoginFail(response.message()?: "")
            }
        }
    }
}