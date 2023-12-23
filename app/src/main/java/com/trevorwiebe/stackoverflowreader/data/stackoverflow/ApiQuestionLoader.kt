package com.trevorwiebe.stackoverflowreader.data.stackoverflow

import com.trevorwiebe.stackoverflowreader.data.dto.ComplexQuestionDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiQuestionLoader {

    @GET("/questions/{questionId}/answers?site={siteId}&filter={filter}")
    suspend fun getQuestion(
        @Path("questionId") questionId: String,
        @Path("siteId") siteId: String,
        @Path("filter", encoded = true) filter: String
    ): Response<ComplexQuestionDto>

}