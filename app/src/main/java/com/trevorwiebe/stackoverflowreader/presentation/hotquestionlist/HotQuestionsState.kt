package com.trevorwiebe.stackoverflowreader.presentation.hotquestionlist

import com.trevorwiebe.stackoverflowreader.domain.HotQuestions

data class HotQuestionsState(
    val hotQuestions: List<HotQuestions> = emptyList()
)
