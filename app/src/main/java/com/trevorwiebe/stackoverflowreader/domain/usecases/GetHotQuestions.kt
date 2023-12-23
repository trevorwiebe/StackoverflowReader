package com.trevorwiebe.stackoverflowreader.domain.usecases

import com.trevorwiebe.stackoverflowreader.data.stackoverflow.RetrofitLoader
import com.trevorwiebe.stackoverflowreader.domain.HotQuestion
import com.trevorwiebe.stackoverflowreader.domain.mapper.toHotQuestion

class GetHotQuestions(
    private val retrofitLoader: RetrofitLoader
) {

    suspend operator fun invoke(): List<HotQuestion>? {
        return retrofitLoader.getHotQuestions().body()
            ?.map { it.toHotQuestion() }
    }
}