package com.example.e_commercetask.cartScreen.di

import com.example.e_commercetask.cartScreen.data.data_source.LocalCartDataSource
import com.example.e_commercetask.cartScreen.data.data_source.LocalCartDataSourceImp
import com.example.e_commercetask.cartScreen.data.repository.CartRepositoryImp
import com.example.e_commercetask.cartScreen.domain.repository.CartRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@InstallIn(ViewModelComponent::class)
@Module
abstract class CartModule {

    @Binds
    abstract fun bindLocalDataSource(localDataSource: LocalCartDataSourceImp): LocalCartDataSource

    @Binds
    abstract fun bindRepository(repositoryImp: CartRepositoryImp): CartRepository
}