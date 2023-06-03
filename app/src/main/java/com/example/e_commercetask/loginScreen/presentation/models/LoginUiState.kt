package com.example.e_commercetask.loginScreen.presentation.models

sealed class LoginUiState{
    object SuccessState: LoginUiState()
    data class ErrorState(val errorMessage: String): LoginUiState()
}
