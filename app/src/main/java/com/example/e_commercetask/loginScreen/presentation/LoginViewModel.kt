package com.example.e_commercetask.loginScreen.presentation

import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.model.UriLoader.StreamFactory
import com.example.e_commercetask.loginScreen.domain.models.ValidateLoginErrors
import com.example.e_commercetask.loginScreen.domain.usecase.ValidateLoginDataUseCase
import com.example.e_commercetask.productsList.domain.usecase.LoadProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loadProductsUseCase: LoadProductsUseCase,
    private val validateLoginDataUseCase: ValidateLoginDataUseCase
): ViewModel() {

    fun validateLoginData(userName: String, password:String) =
        validateLoginDataUseCase(userName, password)

}