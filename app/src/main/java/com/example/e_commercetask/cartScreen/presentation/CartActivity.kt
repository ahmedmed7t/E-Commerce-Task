package com.example.e_commercetask.cartScreen.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.e_commercetask.app.hide
import com.example.e_commercetask.app.show
import com.example.e_commercetask.cartScreen.presentation.adapter.CartListHandler
import com.example.e_commercetask.cartScreen.presentation.adapter.CartRecyclerAdapter
import com.example.e_commercetask.databinding.ActivityCartBinding
import com.example.e_commercetask.productsList.data.models.ProductItemModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_cart.cartList

@AndroidEntryPoint
class CartActivity : AppCompatActivity(), CartListHandler {
    private lateinit var binding: ActivityCartBinding
    private val viewModel: CartViewModel by viewModels()
    private val cartAdapter = CartRecyclerAdapter(arrayListOf(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()

        listenToViewModelValues()
        viewModel.loadCart()
    }

    private fun initViews() {
        binding.apply {
            cartList.setHasFixedSize(true)
            cartList.adapter = cartAdapter
            cartCheckout.setOnClickListener {
                viewModel.emptyCart()
            }
        }
    }

    private fun listenToViewModelValues() {
        viewModel.cartModelState.observe(this) {
            binding.cartProgressBar.hide()
            if (it.cartItems.isNotEmpty()) {
                binding.cartList.show()
                binding.cartEmptyView.hide()
                cartAdapter.addProducts(it.cartItems)
                binding.cartTotalAmount.text = "${it.totalAmount} EGP"
            } else {
                binding.apply {
                    cartList.hide()
                    cartTotalAmount.text = "0 EGP"
                    cartEmptyView.show()
                }
            }
        }
    }

    override fun onProductDeleteClicked(product: ProductItemModel) {
        binding.cartProgressBar.show()
        viewModel.deleteCartItem(product)
        viewModel.loadCart()
    }
}