package com.trevorwiebe.stackoverflowreader.domain.usecases

import com.trevorwiebe.stackoverflowreader.data.stackoverflow.HotQuestionLoader
import com.trevorwiebe.stackoverflowreader.domain.HotQuestion
import com.trevorwiebe.stackoverflowreader.domain.mapper.toHotQuestion

class GetHotQuestions(
    private val hotQuestionLoader: HotQuestionLoader
) {

    suspend operator fun invoke(): List<HotQuestion>? {
        return hotQuestionLoader.getHotQuestions().body()
            ?.map { it.toHotQuestion() }
    }
}