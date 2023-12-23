package com.trevorwiebe.stackoverflowreader.domain.usecases

import com.trevorwiebe.stackoverflowreader.data.stackoverflow.HotQuestionLoader

class GetQuestion(
    private val hotQuestionLoader: HotQuestionLoader
) {

    suspend operator fun invoke(
        questionId: String, siteId: String, filter: String
    ){
        hotQuestionLoader.getQuestion(questionId, siteId, filter)
    }
}