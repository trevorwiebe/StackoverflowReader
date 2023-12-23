package com.trevorwiebe.stackoverflowreader.domain.usecases

import com.trevorwiebe.stackoverflowreader.data.stackoverflow.RetrofitLoader

class GetQuestion(
    private val retrofitLoader: RetrofitLoader
) {

    suspend operator fun invoke(
        questionId: String, siteId: String, filter: String
    ){
        retrofitLoader.getQuestion(questionId, siteId, filter)
    }
}