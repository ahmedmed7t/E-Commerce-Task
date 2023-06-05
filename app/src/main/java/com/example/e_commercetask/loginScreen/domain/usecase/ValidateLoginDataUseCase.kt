package com.example.e_commercetask.loginScreen.domain.usecase

import com.example.e_commercetask.loginScreen.domain.models.ValidateLoginErrors
import javax.inject.Inject

class ValidateLoginDataUseCase @Inject constructor() {
    operator fun invoke(userName: String, password: String): Map<String, ValidateLoginErrors>{
        val result = mutableMapOf<String, ValidateLoginErrors>()

        result[UserName] =  if(userName.isEmpty())
            ValidateLoginErrors.Empty
        else if (userName.count() < 8)
            ValidateLoginErrors.Validation_Error
        else
            ValidateLoginErrors.None

        result[Password] =  if(password.isEmpty())
            ValidateLoginErrors.Empty
        else if (password.count() < 6)
            ValidateLoginErrors.Validation_Error
        else
            ValidateLoginErrors.None

        return result
    }

    companion object{
        const val UserName = "UserName"
        const val Password = "Password"
    }
}