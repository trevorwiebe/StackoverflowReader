package com.trevorwiebe.stackoverflowreader.data.stackoverflow

import com.trevorwiebe.stackoverflowreader.domain.HotQuestions
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitLoader {

    @GET("/hot-questions-json")
    suspend fun getHotQuestions(): Response<List<HotQuestions>>

    @GET("/questions/{questionId}/answers?site={siteId}&filter={filter}")
    suspend fun getQuestion(
        @Path("questionId") questionId: String,
        @Path("siteId") siteId: String,
        @Path("filter") filter: String
    )

//    https://api.stackexchange.com/2.3
//    !u.*0VeqBWiJrWzd1n5JTZcq7D9h_ZtQ

}