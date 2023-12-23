package com.trevorwiebe.stackoverflowreader.domain.usecases

import com.trevorwiebe.stackoverflowreader.data.stackoverflow.RetrofitLoader
import com.trevorwiebe.stackoverflowreader.domain.HotQuestions

class GetHotQuestions(
    private val retrofitLoader: RetrofitLoader
) {

    suspend operator fun invoke(): List<HotQuestions>? {
        return retrofitLoader.getHotQuestions().body()
    }
}