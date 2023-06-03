package com.example.e_commercetask.loginScreen.data.repository

import com.example.e_commercetask.loginScreen.domain.repository.LoginRepository
import com.example.e_commercetask.productsList.data.data_source.ProductsListDataSource
import com.example.e_commercetask.productsList.domain.repository.ProductsListRepository
import javax.inject.Inject

class LoginRepositoryImp @Inject constructor(private val dataSource: ProductsListDataSource): LoginRepository {
}