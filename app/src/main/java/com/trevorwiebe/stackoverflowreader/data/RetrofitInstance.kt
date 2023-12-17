package com.trevorwiebe.stackoverflowreader

import com.trevorwiebe.stackoverflowreader.data.QuestionLoader
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: QuestionLoader by lazy {
        Retrofit.Builder()
            .baseUrl("https://stackexchange.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionLoader::class.java)
    }
}