package com.trevorwiebe.stackoverflowreader.data.stackoverflow

import com.trevorwiebe.stackoverflowreader.data.dto.ComplexQuestionDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiQuestionLoader {

    @GET("/questions/{questionId}/answers")
    suspend fun getQuestion(
        @Path("questionId") questionId: String,
        @Query("site") siteId: String,
        @Query("filter", encoded = false) filter: String
    ): Response<ComplexQuestionDto>

}