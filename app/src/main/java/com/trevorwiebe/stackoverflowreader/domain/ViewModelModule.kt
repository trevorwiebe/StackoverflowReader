package com.trevorwiebe.stackoverflowreader.domain

import com.trevorwiebe.stackoverflowreader.data.stackoverflow.RetrofitLoader
import com.trevorwiebe.stackoverflowreader.domain.usecases.GetHotQuestions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideGetHotQuestions(
        retrofitLoader: RetrofitLoader
    ): GetHotQuestions{
        return GetHotQuestions(retrofitLoader = retrofitLoader)
    }
}