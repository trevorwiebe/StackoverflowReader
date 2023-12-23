package com.trevorwiebe.stackoverflowreader.domain.usecases

import com.trevorwiebe.stackoverflowreader.data.dto.ComplexQuestionDto
import com.trevorwiebe.stackoverflowreader.data.stackoverflow.ApiQuestionLoader

class GetQuestion(
    private val apiQuestionLoader: ApiQuestionLoader
) {

    suspend operator fun invoke(
        questionId: String, siteId: String, filter: String
    ): ComplexQuestionDto? {
        return apiQuestionLoader.getQuestion(questionId, siteId, filter).body()
    }
}