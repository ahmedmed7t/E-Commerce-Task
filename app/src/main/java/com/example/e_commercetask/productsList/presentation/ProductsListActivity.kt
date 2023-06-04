package com.example.e_commercetask.productsList.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import com.example.e_commercetask.app.hide
import com.example.e_commercetask.app.show
import com.example.e_commercetask.app.showErrorToast
import com.example.e_commercetask.databinding.ActivityProductsListBinding
import com.example.e_commercetask.detailsScreen.ProductDetailsActivity
import com.example.e_commercetask.productsList.data.models.ProductItemModel
import com.example.e_commercetask.productsList.presentation.adapter.ProductListHandler
import com.example.e_commercetask.productsList.presentation.adapter.ProductsRecyclerAdapter
import com.example.e_commercetask.productsList.presentation.models.ProductsUIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsListActivity : AppCompatActivity(), ProductListHandler {
    private lateinit var binding: ActivityProductsListBinding
    private val viewModel: ProductsListViewModel by viewModels()
    private val productsAdapter = ProductsRecyclerAdapter(arrayListOf(), this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

        listenToViewModelValues()
        viewModel.loadAllProducts()
    }

    private fun initViews() {
        binding.apply {
            productsRecyclerView.apply {
                setHasFixedSize(true)
                adapter = productsAdapter
            }
            productsSearch.addTextChangedListener {
                viewProductsList(viewModel.filterList(it.toString()))
            }
        }
    }

    private fun listenToViewModelValues() {
        viewModel.loadProductsState.observe(this) {
            binding.productsProgressBar.hide()
            when (it) {
                is ProductsUIState.Fail -> {
                    viewProductsList(arrayListOf())
                    showErrorToast(it.errorMessage)
                }

                is ProductsUIState.Success -> {
                    viewProductsList(it.products)
                }
            }
        }
    }

    private fun viewProductsList(products: ArrayList<ProductItemModel>) =
        binding.apply {
            productsAdapter.addProducts(products)
            if (products.isEmpty()) {
                productEmptyView.show()
                productsRecyclerView.hide()
            } else {
                productEmptyView.hide()
                productsRecyclerView.show()
            }
        }

    override fun onProductClicked(product: ProductItemModel) {
        ProductDetailsActivity.getDetailsIntent(this, product)
    }

    override fun onAddProductToCart(product: ProductItemModel) {

    }
}