package com.example.e_commercetask.productsList.presentation

import androidx.lifecycle.ViewModel
import com.example.e_commercetask.productsList.domain.usecase.LoadProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor(
    private val loadProductsUseCase: LoadProductsUseCase
): ViewModel() {
}