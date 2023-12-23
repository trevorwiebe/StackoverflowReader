package com.trevorwiebe.stackoverflowreader.presentation.hotquestionlist

import com.trevorwiebe.stackoverflowreader.domain.HotQuestion

data class HotQuestionsState(
    val hotQuestions: List<HotQuestion> = emptyList()
)
