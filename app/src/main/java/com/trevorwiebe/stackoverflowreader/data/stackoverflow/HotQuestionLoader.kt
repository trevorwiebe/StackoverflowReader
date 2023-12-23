package com.trevorwiebe.stackoverflowreader.data.stackoverflow

import com.trevorwiebe.stackoverflowreader.data.dto.HotQuestionDto
import retrofit2.Response
import retrofit2.http.GET

interface HotQuestionLoader {

    @GET("/hot-questions-json")
    suspend fun getHotQuestions(): Response<List<HotQuestionDto>>

}