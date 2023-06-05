package com.example.e_commercetask.loginScreen.domain.models

sealed class LoginNetworkState {
    data class LoginSuccess(val token: String) : LoginNetworkState()
    data class LoginFail(val errorMessage: String) : LoginNetworkState()
}
