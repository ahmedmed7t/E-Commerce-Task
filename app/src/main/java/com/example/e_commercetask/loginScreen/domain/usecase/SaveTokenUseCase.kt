package com.example.e_commercetask.loginScreen.domain.usecase

import com.example.e_commercetask.loginScreen.domain.repository.LoginRepository
import javax.inject.Inject

class SaveTokenUseCase @Inject constructor(private val loginRepository: LoginRepository) {
    operator fun invoke(token: String){
        loginRepository.saveUserToken(token)
    }
}