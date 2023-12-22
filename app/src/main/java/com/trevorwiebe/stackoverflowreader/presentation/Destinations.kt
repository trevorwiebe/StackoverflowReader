package com.trevorwiebe.stackoverflowreader.presentation

interface Destinations {
    val route: String
}

object HotQuestionsList: Destinations{
    override val route: String = "questions_list"
}

object HotQuestionItem: Destinations{
    override val route: String = "question_item"
}