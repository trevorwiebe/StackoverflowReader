package com.trevorwiebe.stackoverflowreader.data.di

import com.trevorwiebe.stackoverflowreader.data.stackoverflow.HotQuestionLoader
import com.trevorwiebe.stackoverflowreader.data.util.BASE_URL
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
    fun provideHotQuestionLoader(): HotQuestionLoader {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HotQuestionLoader::class.java)
    }
}