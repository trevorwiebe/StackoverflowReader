package com.trevorwiebe.stackoverflowreader.data.stackoverflow

import com.trevorwiebe.stackoverflowreader.data.dto.ComplexQuestionDto
import com.trevorwiebe.stackoverflowreader.data.dto.HotQuestionDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HotQuestionLoader {

    @GET("/hot-questions-json")
    suspend fun getHotQuestions(): Response<List<HotQuestionDto>>

    @GET("/questions/{questionId}/answers?site={siteId}&filter={filter}")
    suspend fun getQuestion(
        @Path("questionId") questionId: String,
        @Path("siteId") siteId: String,
        @Path("filter", encoded = true) filter: String
    ): Response<ComplexQuestionDto>

}