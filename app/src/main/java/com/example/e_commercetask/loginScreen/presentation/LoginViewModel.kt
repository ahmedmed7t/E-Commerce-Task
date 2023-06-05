package com.example.e_commercetask.loginScreen.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.model.UriLoader.StreamFactory
import com.example.e_commercetask.loginScreen.domain.models.LoginNetworkState
import com.example.e_commercetask.loginScreen.domain.models.ValidateLoginErrors
import com.example.e_commercetask.loginScreen.domain.usecase.LoginUseCase
import com.example.e_commercetask.loginScreen.domain.usecase.SaveTokenUseCase
import com.example.e_commercetask.loginScreen.domain.usecase.ValidateLoginDataUseCase
import com.example.e_commercetask.loginScreen.presentation.models.LoginUiState
import com.example.e_commercetask.productsList.domain.usecase.LoadProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val validateLoginDataUseCase: ValidateLoginDataUseCase,
    private val saveTokenUseCase: SaveTokenUseCase
): ViewModel() {

    private val _loginState = MutableLiveData<LoginUiState>()
    val loginState: LiveData<LoginUiState> get() = _loginState

    fun validateLoginData(userName: String, password:String) =
        validateLoginDataUseCase(userName, password)

    fun loginUser(userName: String, password: String){
        viewModelScope.launch {
            loginUseCase(userName,password).let {
                when(it){
                    is LoginNetworkState.LoginFail ->
                        _loginState.value = LoginUiState.ErrorState(it.errorMessage)
                    is LoginNetworkState.LoginSuccess -> {
                        _loginState.value = LoginUiState.SuccessState
                        saveTokenUseCase(it.token)
                    }
                }
            }
        }
    }
}