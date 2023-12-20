package com.trevorwiebe.stackoverflowreader.data.di

import android.content.Context
import android.speech.tts.TextToSpeech
import com.trevorwiebe.stackoverflowreader.data.tts.TTSHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TTSModule {

    @Provides
    @Singleton
    fun provideTTSHelper(
        @ApplicationContext context: Context,
    ): TTSHelper {
        val tts = TextToSpeech(context) {}
        return TTSHelper(tts)
    }

}