package com.trevorwiebe.stackoverflowreader.data.di

import com.trevorwiebe.stackoverflowreader.data.stackoverflow.RetrofitLoader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofitLoader(): RetrofitLoader {
        return Retrofit.Builder()
            .baseUrl("https://stackexchange.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitLoader::class.java)
    }
}