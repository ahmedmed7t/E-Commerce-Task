package com.example.e_commercetask.productsList.di

import com.example.e_commercetask.productsList.data.repository.ProductsListRepositoryImp
import com.example.e_commercetask.productsList.data.data_source.ProductsListDataSource
import com.example.e_commercetask.productsList.data.data_source.ProductsListDataSourceImp
import com.example.e_commercetask.productsList.domain.repository.ProductsListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@InstallIn(ViewModelComponent::class)
@Module
abstract class ProductsListModule {

    @Binds
    abstract fun bindRemoteDataSource(remoteDataSource: ProductsListDataSourceImp): ProductsListDataSource

    @Binds
    abstract fun bindRepository(repositoryImp: ProductsListRepositoryImp): ProductsListRepository
}