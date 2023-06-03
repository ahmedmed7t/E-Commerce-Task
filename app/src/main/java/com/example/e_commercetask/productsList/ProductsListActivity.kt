package com.example.e_commercetask.productsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.e_commercetask.databinding.ActivityProductsListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}