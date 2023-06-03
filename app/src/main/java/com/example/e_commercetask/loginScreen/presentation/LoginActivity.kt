package com.example.e_commercetask.loginScreen.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.e_commercetask.R
import com.example.e_commercetask.app.hide
import com.example.e_commercetask.app.hideError
import com.example.e_commercetask.app.show
import com.example.e_commercetask.app.showError
import com.example.e_commercetask.databinding.ActivityLoginBinding
import com.example.e_commercetask.loginScreen.domain.models.ValidateLoginErrors
import com.example.e_commercetask.loginScreen.domain.usecase.ValidateLoginDataUseCase
import com.example.e_commercetask.loginScreen.presentation.models.LoginUiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        listenToViewModelValues()
    }

    private fun initViews() {
        binding.apply {
            loginButton.setOnClickListener {
                if (handleValidationResult(
                        viewModel.validateLoginData(
                            loginUserName.text.toString(),
                            loginPassword.text.toString()
                        )
                    )
                ) {
                    loginLoading.show()
                    viewModel.loginUser(
                        loginUserName.text.toString(),
                        loginPassword.text.toString()
                    )
                }
            }
        }
    }

    private fun listenToViewModelValues() {
        viewModel.loginState.observe(this) { loginState ->
            binding.loginLoading.hide()
            when (loginState) {
                is LoginUiState.ErrorState -> Toast.makeText(
                    this,
                    loginState.errorMessage,
                    Toast.LENGTH_LONG
                ).show()

                LoginUiState.SuccessState -> Toast.makeText(this, "Success", Toast.LENGTH_LONG)
                    .show()
            }

        }
    }

    private fun handleValidationResult(validationState: Map<String, ValidateLoginErrors>): Boolean {
        if (validationState[ValidateLoginDataUseCase.UserName] == ValidateLoginErrors.None &&
            validationState[ValidateLoginDataUseCase.Password] == ValidateLoginErrors.None
        ) {
            // if username and password match data criteria
            hideAllScreenErrors()
            return true
        }
        validationState[ValidateLoginDataUseCase.UserName]?.let { validateUserName(it) }
        validationState[ValidateLoginDataUseCase.Password]?.let { validatePassword(it) }
        return false
    }

    private fun validateUserName(userNameValidateError: ValidateLoginErrors) {
        binding.apply {
            when (userNameValidateError) {
                ValidateLoginErrors.None -> {
                    loginUserName.hideError()
                    loginUserNameError.hide()
                }

                ValidateLoginErrors.Validation_Error -> {
                    showUsernameError(getString(R.string.enter_valid_username))
                }

                ValidateLoginErrors.Empty -> {
                    showUsernameError(getString(R.string.enter_a_username))
                }
            }
        }
    }

    private fun validatePassword(passwordValidateError: ValidateLoginErrors) {
        binding.apply {
            when (passwordValidateError) {
                ValidateLoginErrors.None -> {
                    loginPassword.hideError()
                    loginPasswordError.hide()
                }

                ValidateLoginErrors.Validation_Error -> {
                    showPasswordError(getString(R.string.enter_valid_password))
                }

                ValidateLoginErrors.Empty -> {
                    showPasswordError(getString(R.string.enter_a_password))
                }
            }
        }
    }

    private fun hideAllScreenErrors() {
        binding.apply {
            loginUserName.hideError()
            loginPassword.hideError()
            loginUserNameError.hide()
            loginPasswordError.hide()
        }
    }

    private fun showUsernameError(errorMessage: String) {
        binding.apply {
            loginUserName.showError()
            loginUserNameError.show()
            loginUserNameError.text = errorMessage
        }
    }

    private fun showPasswordError(errorMessage: String) {
        binding.apply {
            loginPassword.showError()
            loginPasswordError.show()
            loginPasswordError.text = errorMessage
        }
    }
}