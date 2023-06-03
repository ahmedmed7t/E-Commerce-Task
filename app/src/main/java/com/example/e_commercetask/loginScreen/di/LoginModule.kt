package com.example.e_commercetask.loginScreen.di

import com.example.e_commercetask.loginScreen.data.data_source.LoginDataSource
import com.example.e_commercetask.loginScreen.data.data_source.LoginDataSourceImp
import com.example.e_commercetask.loginScreen.data.repository.LoginRepositoryImp
import com.example.e_commercetask.loginScreen.domain.repository.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class LoginModule {

    @Binds
    abstract fun bindRemoteDataSource(remoteDataSource: LoginDataSourceImp): LoginDataSource

    @Binds
    abstract fun bindRepository(repositoryImp: LoginRepositoryImp): LoginRepository
}