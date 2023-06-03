package com.example.e_commercetask.loginScreen.data.local_data_sorce

import android.content.SharedPreferences
import com.example.e_commercetask.app.models.Constants
import javax.inject.Inject

class LocalLoginDSImp @Inject constructor(
    private val sharedPreferences: SharedPreferences
): LocalLoginDS {
    override fun saveUserToken(userToken: String) {
       sharedPreferences.edit().putString(Constants.UserToken, userToken).apply()
    }
}