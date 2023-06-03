package com.example.e_commercetask.loginScreen.data.data_source

import com.example.e_commercetask.app.api.ApiService
import com.example.e_commercetask.productsList.data.data_source.ProductsListDataSource
import javax.inject.Inject

class LoginDataSourceImp @Inject constructor(private val apiService: ApiService): LoginDataSource {
}