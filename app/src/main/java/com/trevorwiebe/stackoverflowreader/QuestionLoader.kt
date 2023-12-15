package com.trevorwiebe.stackoverflowreader

import retrofit2.Response
import retrofit2.http.GET

interface QuestionLoader {

    @GET("/hot-questions-json")
    suspend fun getHotQuestions(): Response<List<Questions>>
}