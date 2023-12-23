package com.trevorwiebe.stackoverflowreader.domain

data class HotQuestion(
    val site: String = "",
    val questionId: Int = 0,
    val title: String = "",
    val displayScore: Double = 0.0,
    val iconUrl: String = "",
    val creationDate: Long = 0L,
    val answerCount: Int = 0,
    val userName: String = "",
    val tags: List<String> = emptyList()
)
