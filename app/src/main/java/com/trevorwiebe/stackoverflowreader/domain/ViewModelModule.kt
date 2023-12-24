package com.trevorwiebe.stackoverflowreader.domain

import com.trevorwiebe.stackoverflowreader.data.stackoverflow.ApiQuestionLoader
import com.trevorwiebe.stackoverflowreader.data.stackoverflow.HotQuestionLoader
import com.trevorwiebe.stackoverflowreader.domain.usecases.GetHotQuestions
import com.trevorwiebe.stackoverflowreader.domain.usecases.GetQuestion
import com.trevorwiebe.stackoverflowreader.domain.usecases.StringCleaner
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
        hotQuestionLoader: HotQuestionLoader
    ): GetHotQuestions{
        return GetHotQuestions(hotQuestionLoader = hotQuestionLoader)
    }

    @Provides
    @ViewModelScoped
    fun provideGetQuestion(
        apiQuestionLoader: ApiQuestionLoader,
        stringCleaner: StringCleaner
    ): GetQuestion {
        return GetQuestion(
            apiQuestionLoader = apiQuestionLoader,
            stringCleaner = stringCleaner
        )
    }

    @Provides
    @ViewModelScoped
    fun provideStringCleaner(): StringCleaner {
        return StringCleaner()
    }
}