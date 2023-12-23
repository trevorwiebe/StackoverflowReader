package com.trevorwiebe.stackoverflowreader.data.stackoverflow

import com.trevorwiebe.stackoverflowreader.domain.Questions
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitLoader {

    @GET("/hot-questions-json")
    suspend fun getHotQuestions(): Response<List<Questions>>

}