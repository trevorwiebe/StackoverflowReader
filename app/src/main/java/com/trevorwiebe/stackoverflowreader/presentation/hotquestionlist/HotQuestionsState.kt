package com.trevorwiebe.stackoverflowreader.presentation.hotquestionlist

import com.trevorwiebe.stackoverflowreader.domain.Questions

data class HotQuestionsState(
    val hotQuestions: List<Questions> = emptyList()
)
