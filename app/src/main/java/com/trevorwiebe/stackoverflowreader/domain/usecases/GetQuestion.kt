package com.trevorwiebe.stackoverflowreader.domain.usecases

import com.trevorwiebe.stackoverflowreader.data.dto.ComplexQuestionDto
import com.trevorwiebe.stackoverflowreader.data.stackoverflow.ApiQuestionLoader

class GetQuestion(
    private val apiQuestionLoader: ApiQuestionLoader,
    private val stringCleaner: StringCleaner
) {

    suspend operator fun invoke(
        questionId: String, siteId: String, filter: String
    ): ComplexQuestionDto? {
        val complexQuestion = apiQuestionLoader.getQuestion(questionId, siteId, filter).body()

        val updatedList = complexQuestion?.items?.map { items ->
            val cleanString = stringCleaner(items.bodyMarkdown)
            items.copy(bodyMarkdown = cleanString)
        }

        return complexQuestion?.copy(items = updatedList ?: emptyList())
    }
}