package com.trevorwiebe.stackoverflowreader.presentation

import com.trevorwiebe.stackoverflowreader.domain.Questions

data class HotQuestionsState(
    val hotQuestions: List<Questions> = emptyList()
)
