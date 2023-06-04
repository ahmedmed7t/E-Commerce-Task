package com.example.e_commercetask.app.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.e_commercetask.BuildConfig
import com.example.e_commercetask.app.api.ApiService
import com.example.e_commercetask.app.models.Constants
import com.example.e_commercetask.app.models.ErrorInterceptor
import com.example.e_commercetask.app.room.ProductsDao
import com.example.e_commercetask.app.room.ProductsDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        OkHttpClient.Builder()
            .addInterceptor(ErrorInterceptor())
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .addInterceptor(ErrorInterceptor())
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)


    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext appContext: Context): SharedPreferences =
        appContext.getSharedPreferences(Constants.sharedPreferencesName, Context.MODE_PRIVATE)



    @Provides
    @Singleton
    fun provideLocalDataBase(@ApplicationContext appContext: Context): ProductsDataBase =
        Room.databaseBuilder(appContext, ProductsDataBase::class.java, Constants.roomDatabaseName).build()

    @Provides
    fun provideProductsDao(productsDataBase: ProductsDataBase): ProductsDao {
        return productsDataBase.productsDao()
    }
}