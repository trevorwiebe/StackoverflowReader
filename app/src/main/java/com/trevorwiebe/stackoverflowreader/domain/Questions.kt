package com.trevorwiebe.stackoverflowreader.domain

data class Questions(
    val site: String = "",
    val question_id: Int = 0,
    val title: String = "",
    val display_score: Double = 0.0,
    val icon_url: String = "",
    val creation_date: Long = 0L,
    val answer_count: Int = 0,
    val user_name: String = "",
    val tags: List<String> = emptyList()
)
